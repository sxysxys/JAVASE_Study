package filenio.writeAndRead;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @Author: shenge
 * @Date: 2020-04-12 21:50
 *
 * 通过流去写入。将文本转换为大写。
 */
public class StreamInAndOut {
    public static void main(String[] args) {
        try(
                Stream<String> input =
                        Files.lines(Paths.get("ThinkinJava/src/filenio/writeAndRead/StreamInAndOut.java"));
                PrintWriter output =
                        new PrintWriter("StreamInAndOut.txt")
        ) {  //使用自动close。
            input.map(String::toUpperCase)
                    .forEachOrdered(output::println);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
