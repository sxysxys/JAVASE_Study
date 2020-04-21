package string.regex;

import java.util.Arrays;

/**
 * @Author: shenge
 * @Date: 2020-04-13 11:12
 */
public class Splitting {
    public static String knights =
            "Then, when you have found the shrubbery, " +
                    "you must cut down the mightiest tree in the " +
                    "forest...with... a herring!";

    public static void split(String regex) {
        System.out.println(
                Arrays.toString(knights.split(regex)));
    }

    public static void main(String[] args) {
        split("\\W+");  //第一个\代表java中表示我要写正则了，第二个\w表示匹配非单词字符，+表示可以匹配多个。
        split("n\\W+");
    }
}