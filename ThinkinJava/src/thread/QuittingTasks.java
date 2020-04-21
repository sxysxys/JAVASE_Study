package thread;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author: shenge
 * @Date: 2020-04-21 11:47
 */
//将当前线程进行挂起一段时间。
class Nap {
    public Nap(double t) { // Seconds
        try {
            TimeUnit.MILLISECONDS.sleep((int)(1000 * t));
        } catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }
    public Nap(double t, String msg) {
        this(t);
        System.out.println(msg);
    }
}

class QuittableTask implements Runnable {
    final int id;
    public QuittableTask(int id) {
        this.id = id;
    }
    private AtomicBoolean running =
            new AtomicBoolean(true);
    public void quit() {
        running.set(false);
    }
    @Override
    public void run() {
        while(running.get())         // [1]
            new Nap(0.1);
        System.out.print(id + Thread.currentThread().getName()+" ");  // [2]
    }
}


public class QuittingTasks {
    public static final int COUNT = 150;
    public static void main(String[] args) {
        ExecutorService es =
                Executors.newCachedThreadPool();
        List<QuittableTask> tasks =
                IntStream.range(1, COUNT)
                        .mapToObj(QuittableTask::new)
                        .peek(qt -> es.execute(qt))  //创建相应的线程，跑起这150个run。
                        .collect(Collectors.toList());
        new Nap(1);
        tasks.forEach(QuittableTask::quit);     //使用未绑定对各个对象执行quit方法。
        es.shutdown();    //等待那些线程全都停了以后才退出main。
    }
}
