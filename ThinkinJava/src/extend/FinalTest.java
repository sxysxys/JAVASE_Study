package extend;

import java.util.Random;

/**
 * @Author: shenge
 * @Date: 2020-03-31 22:31
 * final属性的测试
 */
public class FinalTest {
    private static Random rand = new Random(47);

    private final int[] a = {1, 2, 3};  //final指的是a引用不变，也就是指向的对象不变，但是对象本身可以改变。
    private final int b = 5;  //如果是基本数据类型，那么就是指向的值不能改变。

    private static final int c = rand.nextInt(20);
    static final int d = rand.nextInt(20);   //初始化一次，然后值不再改变
    private final int e = rand.nextInt(20);  //每次构造一个对象都会重置，但是对于那个对象来说，e的值不会变。


    @Override
    public String toString() {
        return "FinalTest{" +
                "e=" + e +":d="+d+
                '}';
    }

    public static void main(String[] args) {
        FinalTest finalTest = new FinalTest();
        finalTest.a[1] = 5;
        System.out.println(finalTest.a[1]);
        System.out.println("----------------");
        System.out.println(finalTest);
        FinalTest finalTest1 = new FinalTest();
        System.out.println(finalTest1);
    }
}
