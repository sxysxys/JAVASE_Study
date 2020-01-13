package Thread;


/**
 * 需求:银行有一个金库。
 * 有两个储户分别存300元，每次存100，存3次。
 *
 * 找问题：
 * 哪些是多线程运行代码
 * 哪些是共享数据
 * 哪些语句是操作共享数据的
 *
 * 如果一个方法中的所有代码都需要同步，那么只需将方法加上synchronized即可，不需要同步代码块。
 *
 * 那么同步方法用的是哪一个锁呢？
 *方法被对象调用。所以同步方法用的锁是对象本身this
 *
 * 如果同步方法是静态的，那么锁就不再是this，因为静态方法中没有this。
 *
 * java文件从编码到执行，分为两步:编译、执行。
 * 编译就是将向相关类的.java文件编译成class存进内存中，此时静态方法就被加载进了内存中。
 * 执行就是将相应的class文件放入java虚拟机进行执行。
 *
 * 静态的同步方法，使用的锁是该方法所在类的字节码对象。  类名.class
 */
class Bank{
    private int sum;
//    Object o=new Object();
    public synchronized void add(int n){
        sum=sum+n;
        System.out.println("sum="+sum);
    }
}

class Cus implements Runnable{
    private Bank b=new Bank();
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            b.add(100);
        }
    }
}
public class BankDemo {
    public static void main(String[] args) {
        Cus cus = new Cus();  //创建线程
        Thread t1 = new Thread(cus);
        Thread t2 = new Thread(cus);
        t1.start();
        t2.start();
    }
}
