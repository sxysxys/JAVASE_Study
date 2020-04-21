package extend;

import test.ExtendTest;

/**
 * @Author: shenge
 * @Date: 2020-04-01 00:15
 * final测试类
 */
public class FinalTest2 extends ExtendTest {

    /**
     * final在方法上。
     * 不能按如下定义，final修饰的方法不能被重写，但是能被调用。
     * 易得知private上其实自带了final。
     */
//    @Override
//    public void test1(){
//
//    }

    /**
     * final在形参上。
     * @param a
     */
    public void test2(final int a){
//        a=5;        //送进来的值或引用都不能改变了。
    }


}
