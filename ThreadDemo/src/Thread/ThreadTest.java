package Thread;

/**
 * 开发中常见的多线程应用:匿名内部类。
 */
public class ThreadTest {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName()+"...");
                }
            }
        }.start();
        Runnable a=new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName()+"//////");
                }
            }
        };
        Thread thread = new Thread(a);
        thread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+">>>>>");
        }

    }
}
