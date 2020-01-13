package Example;

class MyLock {
    static Object o1 = new Object();
    static Object o2 = new Object();
}

class Test implements Runnable {
    private boolean flag;

    Test(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (MyLock.o1) {
                System.out.println("flag==true");
                synchronized (MyLock.o2) {
                    System.out.println("if flag");
                }
            }
        } else {
            synchronized (MyLock.o2) {
                System.out.println("flag==false");
                synchronized (MyLock.o1) {
                    System.out.println("else flag");
                }
            }
        }
    }
}

/**
 * 死锁demo
 */
public class DeadLockTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Test(true));
        Thread t2 = new Thread(new Test(false));
        t1.start();
        t2.start();
    }
}
