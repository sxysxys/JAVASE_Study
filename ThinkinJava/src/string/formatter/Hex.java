package string.formatter;

/**
 * @Author: shenge
 * @Date: 2020-04-13 10:38
 *
 * 格式化输出.class文件。
 */
import java.nio.file.*;

public class Hex {
    public static String format(byte[] data) {
        StringBuilder result = new StringBuilder();
        int n = 0;
        for(byte b : data) {
            if(n % 16 == 0)
                result.append(String.format("%05X: ", n));
            result.append(String.format("%02X ", b));
            n++;
            if(n % 16 == 0) result.append("\n");
        }
        result.append("\n");
        return result.toString();
    }
    public static void main(String[] args) throws Exception {
        if(args.length == 0)
            // Test by displaying this class file:
            System.out.println(format(
                    Files.readAllBytes(Paths.get(
                            "out/production/ThinkinJava/string/Hex.class"))));
        else
            System.out.println(format(
                    Files.readAllBytes(Paths.get(args[0]))));
    }
}
