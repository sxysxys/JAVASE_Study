package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: shenge
 * @Date: 2020-04-21 11:07
 *
 * 使用线程池装线程:使用lamdba表达式不继承Runable和Callable
 */

class NotAble{
    public void go() {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"NotRunnable");
    }
}

class NotCallable {
    public Integer get() {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"NotCallable");
        return 1;
    }
}

public class LambdasAndMethodReferences {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new NotAble()::go);
        executorService.execute(new NotCallable()::get);

        executorService.shutdown();
    }
}
