package stream.filetowords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @Author: shenge
 * @Date: 2020-04-09 16:59
 *
 * 改进方法。
 */

class FileToWords{
    public static Stream<String> stream(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath))
                .skip(1)
                .flatMap(line-> Pattern.compile("[ .,?]+")
                        .splitAsStream(line));
    }
}

public class FileToWordsTest {
    public static void main(String[] args) throws IOException{
        FileToWords.stream("Cheese.dat")
                .limit(7)
                .forEach(s -> System.out.format("%s ",s));
    }
}
