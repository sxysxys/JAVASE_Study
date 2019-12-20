package RegexExercise;

/**
 * 正则表达式的练习。
 */
public class RegexDemo {
    public static void main(String[] args) {
        checkQQ("213123");
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
}
