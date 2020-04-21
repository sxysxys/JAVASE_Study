package initandclean;

/**
 * @Author: shenge
 * @Date: 2020-03-30 21:28
 */

class Flower{
    int a;
    String s="default";
    Flower(int a){
        this.a=a;
    }
    Flower(int a,String s){
        this(a);
        this.s=s;
    }
//system.gc调用的时候需要确定此时对象没有任何引用。
    @Override
    protected void finalize() throws Throwable {
        System.out.println("会输出吗");
        super.finalize();
    }
}
public class TestThis {
    public static void main(String[] args) {
        new Flower(5, "haha");
        System.gc();
    }
}
