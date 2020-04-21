package string;

/**
 * @Author: shenge
 * @Date: 2020-04-12 23:36
 *
 * String对象的不可变性，每次执行String方法的时候都会创建一个新的String对象。
 *
 * 换句话说，String对象是只读的，任何操作都不可能修改它的值。只会创建一个新的String对象。
 */
public class Immutable {
    public static String upcase(String s) {
        return s.toUpperCase();
    }
    public static void main(String[] args) {
        String q = "howdy";
        System.out.println(q); // howdy
        String qq = upcase(q);
        System.out.println(qq); // HOWDY
        System.out.println(q); // howdy
    }
}
