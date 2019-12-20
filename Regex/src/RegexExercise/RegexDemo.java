package RegexExercise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式的练习。
 */
public class RegexDemo {
    public static void main(String[] args) {
//        checkQQ("213123");
//        demo1();
//        checkTel();
        //用叠词切割
        //(.)代表组，即正则表达式在匹配一个字符过后，将这个字符记录了下来，然后后面如果读到了1就会将前面
        // 的值再次匹配一下。+号代表出现一次或多次。
//        splitDemo("erqqqfdffwewwwddr","(.)\\1+");

//        replaceDemo("WWW123414312ww2312123c343","\\d{5,}","#");  //替换大于5的数字
//        replaceDemo("wwgfgwwfgsdfggdfg","(.)\\1+","$1");//替换叠词,通过$1获取第一组的数值。前面的1和后面的1意思完全不一样
        getdemo("werw rwer e err rrr tyt sfasd","\\b[a-z]{3}\\b");

    }

    /**
     * 匹配qq号
     * @param qq
     */
    public static void checkQQ(String qq){
        String regex="[1-9][0-9]{4,14}";
        boolean matches = qq.matches(regex);
        if (matches){
            System.out.println(qq+" is ok");
        }else {
            System.out.println(qq+" is not ok");
        }
    }

    /**
     * 匹配电话号
     * 第一位是1，第二位是358
     *
     */
    public static void checkTel(){
        String tel="19054542157";
        String telRex="1[358]\\d{9}";
        System.out.println(tel.matches(telRex));
    }

    /**
     *
     * @param str  送入的字符串
     * @param reg  正则表达式
     */
    public static void splitDemo(String str,String reg){
        String[] split = str.split(reg);
        for (String s : split) {
            System.out.println(s);
        }
    }

    /**
     *
     * @param str  被替换的字符
     * @param reg  替换部分的正则表达式匹配
     * @param newstr  将这部分替换成的字符串
     */
    public static void replaceDemo(String str,String reg,String newstr){
        System.out.println(str.replaceAll(reg,newstr));
    }

    /**
     * 将符合规则的字符串子串打印出来
     * @param str
     * @param reg
     */
    public static void getdemo(String str,String reg){
        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher(str);
        while (matcher.find()){
            System.out.println(matcher.group());
        }

    }
    public static void demo1(){
        String str="ba";
        String reg="[bcd][a-c]";
        System.out.println(str.matches(str));
    }
}
