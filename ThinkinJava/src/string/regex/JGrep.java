package string.regex;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: shenge
 * @Date: 2020-04-13 16:58
 *
 * 正则和文件操作的结合。
 *
 */
public class JGrep {
    public static void main(String[] args) throws Exception {
        if(args.length < 2) {
            System.out.println(
                    "Usage: java JGrep file regex");
            System.exit(0);
        }
        Pattern p = Pattern.compile(args[1]);
        // Iterate through the lines of the input file:
        int index = 0;
        Matcher m = p.matcher("");
        for(String line: Files.readAllLines(Paths.get(args[0]))) {
            m.reset(line);
            while(m.find())
                System.out.println(index++ + ": " +
                        m.group() + ": " + m.start());
        }
    }
}
