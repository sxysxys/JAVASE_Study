package string.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: shenge
 * @Date: 2020-04-13 14:42
 *
 * Pattern的用法。
 */
public class Finding {
    public static void main(String[] args) {
        Matcher m = Pattern.compile("\\w+")      //先拿到了一个Pattern，再获取一个匹配器，此时还没开始匹配，等到find等方法执行的时候开始匹配。
                .matcher(
                        "Evening is full of the linnet's wings");
        while(m.find())    //每执行一次find，找到能匹配上的一个子序列，通过group输出。
            System.out.print(m.group() + " ");
        System.out.println();
        int i = 0;
        while(m.find(i)) {
            System.out.print(m.group() + " ");
            i++;
        }
    }
}
