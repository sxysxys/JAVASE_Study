package Example;

import javax.annotation.Resource;

/**
 * 生产者消费者模型
 * 生产几个消费几个
 *
 */
//资源
class Resorce{
    int count=1;
    String name;
    boolean flag=false;
    public synchronized void add(String name){
        while (flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name=name+"----"+count++;
        System.out.println(Thread.currentThread().getName()+"生产者....."+this.name);
        flag=true;
        this.notifyAll();
    }

    public synchronized void get(){
        while (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"消费者........"+this.name);
        flag=false;
        this.notifyAll();
    }
}

class Input implements Runnable{
    private Resorce resorce;
    Input(Resorce resorce){
        this.resorce=resorce;
    }
    @Override
    public void run() {
        while (true)
        resorce.add("张三");
    }
}
class Output implements Runnable{
    private Resorce resorce;
    Output(Resorce resorce){
        this.resorce=resorce;
    }
    @Override
    public void run() {
        while (true)
        resorce.get();
    }
}
public class ProducerCustomerDemo {
    public static void main(String[] args) {
        Resorce resorce = new Resorce();
        Input target = new Input(resorce);
        Output output = new Output(resorce);
        Thread t1 = new Thread(target);
        Thread t2 = new Thread(target);
        Thread t3 = new Thread(output);
        Thread t4 = new Thread(output);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
