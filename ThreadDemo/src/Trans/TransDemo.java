package Trans;

/**
 * 线程间进行通信：
 * 其实就是多个线程在操作同一个资源。、
 * 只不过操作的方式不一样。
 * 但是发现了一个问题，就是同步的时候没有相同的锁。
 * 可以直接使用内存中的对象当作锁，使用内存中的资源对象。
 * <p>
 * 这样又会有问题，可能某个线程一直能够抢占，那么就会一直输出，不会进行数据更新了。
 * 我们想要存一个打印一个。
 * 这时就要用到线程的阻塞和激活。
 * 在线程类中使用r.wait()和r.notify()的时候，等待和激活的不是本线程，而是本锁的线程池中的第一个线程，
 * 执行notify()会查看线程池中哪个线程在等待状态的第一个，然后激活它。
 * notifyAll()：激活所有线程。
 * <p>
 * 为什么wait和notify要定义在Object类中?
 * 因为锁是任意对象，而wait和notify都是针对一个锁，每次执行这种方法都是针对锁的的线程池中的，所以得定义在Object类中。
 */
class Reso {
    String name;
    String sex;
    boolean f = false;
//相当于把自己看成锁
    public synchronized void set(String name, String sex) {
        if (!f) {
            this.name = name;
            this.sex = sex;
            f = true;
            this.notify();
        } else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void get() {
        if (f) {
            System.out.println(this.name + ":" + this.sex);
            f = false;
            this.notify();
        } else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 输入线程
 */
class Input implements Runnable {
    private Reso r;
    boolean flag = true;

    Input(Reso r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            if (flag) {
                if (!r.f) {
                    r.set("zhangsan", "男");
                    flag = false;
                }
            } else {
                if (!r.f) {
                    r.set("lisi", "女");
                    flag = true;
                }
            }
        }
    }
}

/**
 * 输出线程
 */
class Output implements Runnable {
    private Reso r;

    Output(Reso r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.get();
        }
    }
}

public class TransDemo {
    public static void main(String[] args) {
        Reso reso = new Reso();
        Thread t1 = new Thread(new Input(reso));
        Thread t2 = new Thread(new Output(reso));
        t1.start();
        t2.start();
    }
}
