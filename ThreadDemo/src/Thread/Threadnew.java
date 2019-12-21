package Thread;

/**
 * 自定义一个线程
 * 创建线程的第一种方式：继承Thread类。
 */

class Thread1 extends Thread{
    public Thread1(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 60; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
public class Threadnew {
    public static void main(String[] args) {
        Thread1 one = new Thread1("one");
        Thread1 two = new Thread1("two");
        one.start();
        two.start();
        for (int i = 0; i < 60; i++) {
            System.out.println("main:"+i);
        }
    }
}
