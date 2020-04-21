package initandclean;

/**
 * @Author: shenge
 * @Date: 2020-03-31 10:25
 * 静态代码块：在初始化静态变量的时候执行，给静态变量赋值。
 * 非静态代码块：在初始化变量的时候进行，给变量赋值。
 */
class Cup{
    Cup(int a ){
        System.out.println("cup"+a);
    }
    void f(int a ){
        System.out.println("f"+a);
    }
}

class Cups{
    static Cup cup1;
    static Cup cup2;
    int a;
    static {
        cup1=new Cup(1);
        cup2=new Cup(2);
    }
    {
        a=5;
    }
    Cups(int a){
        System.out.println(this.a);
        System.out.println("cups"+a);
    }
}
public class Block {
    public static void main(String[] args) {
        Cups.cup1.f(1);
        System.out.println("-------------------");
        new Cups(3);
    }
}
