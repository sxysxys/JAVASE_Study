package Thread;

/**
 * 售票方式2，使用Runable接口实现类的run方法。
 * 这种线程方式可以实现变量共享
 */
class Ticket2 implements Runnable{
    private int tick=100;
    @Override
    public void run() {
        while (true){
            if (tick>0)
            System.out.println(Thread.currentThread().getName()+"sale:"+tick--);
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
