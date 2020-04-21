package filenio.path;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author: shenge
 * @Date: 2020-04-11 19:56
 *
 * 路径的api、遍历。
 */
public class PartsOfPaths {
    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        Path p = Paths.get("PartsOfPaths.java").toAbsolutePath();
        for(int i = 0; i < p.getNameCount(); i++)
            System.out.println(p.getName(i));
        System.out.println("ends with '.java': " +
                p.endsWith(".java"));     //虽然最后的文件是以.java结尾的，但是比较的是整个路径，所以为false；如果和PartsOfPaths.java比较，那就是true。
        System.out.println("ends with 'PartsOfPaths.java': " +
                p.endsWith("PartsOfPaths.java"));
        for(Path pp : p) {     //可以遍历出一个个相对路径。
            System.out.print(pp + ": ");
            System.out.print(p.startsWith(pp) + " : ");
            System.out.println(p.endsWith(pp));
        }
        System.out.println("Starts with " + p.getRoot() + " " + p.startsWith(p.getRoot()));
    }
}

