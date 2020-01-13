package Thread;

/**
 * 售票方式2，使用Runable接口实现类的run方法。
 * 这种线程方式可以实现变量共享
 * 但是也会出现安全问题。
 * 一个线程还没执行完，另一个线程进来执行，造成了数据共享的错误。
 * 解决方法：
 * 对多条操作共享数据的语句，只能让一个线程都执行完，在执行过程中，其他线程不能参与执行。
 * 用java中的同步代码块。
 *
 * 传入同步代码块的对象如锁，持有锁的线程可以在同步中执行，没有锁的对象就算有执行权也进不去，因为没有锁。
 *
 * 经典：火车上的卫生间。
 *
 * 同步的前提，必须要有两个或者两个以上的线程。
 *
 * 好处：解决了多线程的安全问题。
 * 坏处：线程每次判断锁，消耗资源。
 */
class Ticket2 implements Runnable{
    private int tick=100;
    Object o=new Object();
    @Override
    public void run() {
        while (true){
            synchronized (o) {
                if (tick > 0) {
                    try {
                        Thread.sleep(10);    //模拟可能出现的线程冲突。打印出了0，-1，-2等错票。
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "sale:" + tick--);
                }
            }
        }
    }
}

public class TicketDemo2 {
    public static void main(String[] args) {
        Ticket2  t1 = new Ticket2();
        Thread th1 = new Thread(t1);
        Thread th2 = new Thread(t1);
        Thread th3 = new Thread(t1);
        Thread th4 = new Thread(t1);
        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }
}
