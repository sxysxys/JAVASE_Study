package filenio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import tools.Rmdir;      //引入的删除工具类。

/**
 * @Author: shenge
 * @Date: 2020-04-12 09:37
 *
 * 目录删除、遍历等操作。
 */
public class Directories {
    static Path test = Paths.get("test");
    static String sep = FileSystems.getDefault().getSeparator();
    static List<String> parts = Arrays.asList("foo", "bar", "baz", "bag");

    static Path makeVariant() {
        Collections.rotate(parts, 1);   //就是相当于往右移了一格。
        return Paths.get("test", String.join(sep, parts));
    }

    static void refreshTestDir() throws Exception {
        if(Files.exists(test))
            Rmdir.rmdir(test);
        if(!Files.exists(test))
            Files.createDirectory(test);
    }

    static void deleteTxt(Stream<Path> pathStream){
        pathStream.filter(i->i.toString().endsWith(".txt")).forEach(i->{
            System.out.println("delete:"+i);
            try {
                Files.delete(i);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static void main(String[] args) throws Exception {
        refreshTestDir();
        Files.createFile(test.resolve("Hello.txt"));
        Path variant = makeVariant();
        // Throws exception (too many levels):
        try {
            Files.createDirectory(variant);
        } catch(Exception e) {
            System.out.println("Nope, that doesn't work.");
        }
        populateTestDir();
        Path tempdir = Files.createTempDirectory(test, "DIR_");
        Files.createTempFile(tempdir, "pre", ".non");
        Files.newDirectoryStream(test).forEach(System.out::println);
        System.out.println("*********");
        Files.walk(test).forEach(System.out::println);  //遍历目录。
        deleteTxt(Files.walk(test));

//        Rmdir.rmdir(test);
    }

    static void populateTestDir() throws Exception  {
        for(int i = 0; i < parts.size(); i++) {
            Path variant = makeVariant();
            if(!Files.exists(variant)) {
                Files.createDirectories(variant);
                Files.copy(Paths.get("Directories.java"),
                        variant.resolve("File.txt"));     //复制文件。
                Files.createTempFile(variant, null, null);  //在每个目录下创建一个临时文件。
            }
        }
    }

}
