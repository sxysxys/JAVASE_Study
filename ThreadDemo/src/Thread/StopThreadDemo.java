package Thread;

/**
 * 让循环结束的线程
 * stop()方法被废除了
 *
 * 这时只需控制住run方法里的循环，就能让线程结束。
 *
 * 如果线程进入了wait()状态，就不会读到标记，线程就不会结束。
 * 如果此时想要结束线程，就必须让线程重新回到运行状态中来。
 * 此时通过interrupt()强制唤醒线程，让线程进入wait的Interrupt异常。从而判断相应的标志位去结束异常。
 *
 *
 */

class StopThread implements Runnable {
    private boolean flag=true;
    private int count;
    @Override
    public synchronized void run() {
        while (flag){
            System.out.println(Thread.currentThread().getName()+"......"+count++);
            try{
                wait();
            }catch (InterruptedException e){
                System.out.println(Thread.currentThread().getName()+"概述了异常");
                flag=false;
            }
        }
    }
    public void changeFlag(){
        flag=false;
    }
}

public class StopThreadDemo {
    public static void main(String[] args) {
        int num=0;
        StopThread stopThread = new StopThread();
        Thread t1 = new Thread(stopThread);
        Thread t2 = new Thread(stopThread);
        //第三种方法：将线程标记为后台线程，一旦主线程（前台线程停止）停止，后台线程就会自动停止。
        t1.setDaemon(true);
        t2.setDaemon(true);
        t1.start();
        t2.start();
        while (true){
            num++;
            if (num==60){
                //第一种方法，改变标志位去结束，但是当线程等待的时候不顶用
//                stopThread.changeFlag();
                //第二种方法，interrupt唤醒线程。
//                t1.interrupt();
//                t2.interrupt();
                break;
            }
            System.out.println(Thread.currentThread().getName()+"......"+num);
        }
    }
}
