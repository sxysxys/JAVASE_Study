package Example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者模型
 * 基于jdk5.0的新特性
 *
 */
//资源
class Ziyuan{
    int count=1;
    String name;
    boolean flag=false;
    Lock lock = new ReentrantLock();  //相当于本对象的锁
    Condition condition_pro = lock.newCondition();
    Condition condition_con = lock.newCondition();
    public void add(String name)throws Exception{
        lock.lock();
        try {
            while (flag){
                condition_pro.await();
            }
            this.name=name+"----"+count++;
            System.out.println(Thread.currentThread().getName()+"生产者....."+this.name);
            flag=true;
            condition_con.signal();
        }finally {
            lock.unlock();
        }
    }

    public synchronized void get()throws Exception{
        lock.lock();
        try {
            while (!flag){
                condition_con.await();
            }
            System.out.println(Thread.currentThread().getName()+"消费者........"+this.name);
            flag=false;
            condition_pro.signal();
        }finally {
            lock.unlock();
        }
    }
}

class Producer implements Runnable{
    private Ziyuan z;
    Producer(Ziyuan Ziyuan){
        this.z=Ziyuan;
    }
    @Override
    public void run() {
        while (true)
            try {
                z.add("张三");
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}

class Consumer implements Runnable{
    private Ziyuan z;
    Consumer(Ziyuan z){
        this.z=z;
    }
    @Override
    public void run() {
        while (true)
            try {
                z.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}

public class ProducerDemoNewJdk {
    public static void main(String[] args) {
        Ziyuan ziyuan = new Ziyuan();
        Producer producer = new Producer(ziyuan);
        Consumer consumer = new Consumer(ziyuan);
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(producer);
        Thread t3 = new Thread(consumer);
        Thread t4 = new Thread(consumer);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
