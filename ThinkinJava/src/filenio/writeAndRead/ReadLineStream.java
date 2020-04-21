package filenio.writeAndRead;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Author: shenge
 * @Date: 2020-04-12 21:38
 *
 * 按每一行的流来读。
 */
public class ReadLineStream {
    public static void main(String[] args) throws Exception {
        Files.lines(Paths.get("Cheese.dat"))
                .skip(3)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
