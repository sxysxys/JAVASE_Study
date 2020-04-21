package initandclean;

/**
 * @Author: shenge
 * @Date: 2020-03-31 00:22
 * 初始化测试
 */

/**
 * 普通初始化
 */
class MethodInit1 {
    int i=f();
    int j=g(i);  //i,j位置互换就不行，因为初始化是按顺序执行的
    int f(){
        return 11;
    }
    int g(int n){
        return n+2;
    }

    @Override
    public String toString() {
        return "MethodInit1{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }
}

/**
 * 构造器初始化
 */

class Window{
    Window(int a){
        System.out.println("Window"+a);
    }
}
class MethodInit2{
    Window w1=new Window(1);
    Window w2=new Window(2);
    MethodInit2(){
        /**
         * 这个地方其实会对类中的所有属性初始化。
         */
        System.out.println("MethodInit2()");
        w3=new Window(5);
    }
    Window w3=new Window(3);

}


//assertTest
public class InitOrder {
    public static void main(String[] args) {
        System.out.println("Method1:");
        MethodInit1 methodInit1 = new MethodInit1();
        System.out.println(methodInit1);
        System.out.println("Method2:");
        MethodInit2 methodInit2 = new MethodInit2();
    }
}
