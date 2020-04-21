package filenio.path;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author: shenge
 * @Date: 2020-04-11 20:17
 *
 * Path.get不会帮你去找你输入文件的路径，他会直接在当前工作目录下把你输入的文件名称拼接上去然后返回你一个Path。
 *
 * 只有toRealPath会去真正进行nomalize后关联到相应的文件或目录，返回一个真正存在的路径。
 *
 *
 */
public class AddAndSubtractPaths {
    static Path base = Paths.get("..","..","..").toAbsolutePath().normalize();      //..的意思是目录往前面走多少格。

    static void show(int id, Path result) {
        if(result.isAbsolute())
            System.out.println("(" + id + ")r " + base.relativize(result));  //取两个路径之间的相对路径。
        else
            System.out.println("(" + id + ") " + result);
        try {
            Path path = result.toRealPath();
            System.out.println("RealPath: " + path);   //这里才会去看你的真实路径。
        } catch(IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        System.out.println(base);
        Path p = Paths.get("ThinkinJava/src/filenio/path/AddAndSubtractPaths.java").toAbsolutePath();
        show(1, p);
        Path convoluted = p.getParent().getParent()
                .resolve("strings").resolve("..")
                .resolve(p.getParent().getFileName());   //将名称加在路径后面。
        show(2, convoluted);
        show(3, convoluted.normalize());
        Path p2 = Paths.get("..", "..");
        show(4, p2);
        show(5, p2.normalize());   //只对绝对路径有效。
        show(6, p2.toAbsolutePath().normalize());   //将..去掉了。
        Path p3 = Paths.get(".").toAbsolutePath();
        Path p4 = p3.resolve(p2);
        show(7, p4);
        show(8, p4.normalize());
        Path p5 = Paths.get("").toAbsolutePath();   //啥也不送
        show(9, p5);
        show(10, p5.resolveSibling("strings"));
        show(11, Paths.get("nonexistent"));
    }
}
