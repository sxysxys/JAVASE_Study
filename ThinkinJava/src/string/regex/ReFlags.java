package string.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: shenge
 * @Date: 2020-04-13 16:02
 */
public class ReFlags {
    public static void main(String[] args) {
        Pattern p =  Pattern.compile("^java",
                Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);    //MULTILINE会将^、$当做一行的开始和结束，而正常情况下会当做整个字符串的开始和结束。
        Matcher m = p.matcher(
                "java has regex\nJava has regex\n" +
                        "JAVA has pretty good regular expressions\n" +
                        "Regular expressions are in Java");
        while(m.find())
            System.out.println(m.group());
    }
}
