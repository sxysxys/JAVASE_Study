package filenio.writeAndRead;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Author: shenge
 * @Date: 2020-04-12 21:10
 *
 * 读文件。
 */
public class ListOfLines {
    public static void main(String[] args) throws Exception {
        Files.readAllLines(
                Paths.get("Cheese.dat"))
                .stream()
                .filter(line -> !line.startsWith("//"))
                .map(line ->
                        line.substring(0, line.length()/2))
                .forEach(System.out::println);
    }
}