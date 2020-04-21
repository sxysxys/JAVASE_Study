package initandclean;

/**
 * @Author: shenge
 * @Date: 2020-03-31 11:22
 * 数组初始化和可变参数
 * 可变参数会将所有送过来的实参封装成数组
 */
public class ArrayInit {
    static void f(int a,String...  b){
        System.out.println("a:"+a);
        for (String s : b) {
            System.out.println("b:"+s);
        }
    }

    public static void main(String[] args) {
        f(5,"one","two");
        System.out.println("----------------");
        f(5,new String[] {"123","456"});
    }
}
