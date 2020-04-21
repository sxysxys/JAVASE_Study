package initandclean;

/**
 * @Author: shenge
 * @Date: 2020-03-31 11:36
 * 测试数组可变参数的重载
 */

public class ArrayTest {
    static void f(float i,Character... args){
        System.out.println("first");
    }
    static void f(Character... args){
        System.out.println("second");
    }
    public static void main(String[] args) {
        f(1,'a');  //这个没问题，因为自动匹配到第一个。
        //f('c','a');  //这个会出问题，因为两个都能匹配。
    }
}
