package interfaces;

/**
 * @Author: shenge
 * @Date: 2020-04-01 22:10
 */

interface Test1 {
    void haha();
}

public class Test1ComeTrue implements Test1{
    @Override
    public void haha() {   //可以和继承一样，改变相应的修饰符
        System.out.println("我成了");
    }


}
