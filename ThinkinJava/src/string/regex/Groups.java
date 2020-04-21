package string.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: shenge
 * @Date: 2020-04-13 15:07
 *
 * 分组的概念，按括号来。
 */
public class Groups {
    public static final String POEM =
            "Twas brillig, and the slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves,\n" +
                    "And the mome raths outgrabe.\n\n" +
                    "Beware the Jabberwock, my son,\n" +
                    "The jaws that bite, the claws that catch.\n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "The frumious Bandersnatch.";
    public static void main(String[] args) {
        Matcher m = Pattern.compile(
                "(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$")
                .matcher(POEM);
        while(m.find()) {
            int i = m.groupCount();    //总共有5组。第0组是整个把括号去掉看，第一组是加上第一个括号，以此类推。
            for(int j = 0; j <= i; j++)
                System.out.print("[" + m.group(j) + "]");
            System.out.println();
        }
    }
}