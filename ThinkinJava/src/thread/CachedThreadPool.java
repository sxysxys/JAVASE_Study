package thread;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author: shenge
 * @Date: 2020-04-21 11:17
 *
 * 使用多线程池。
 */

class CountingTask implements Callable<Integer> {
    final int id;
    public CountingTask(int id) { this.id = id; }
    @Override
    public Integer call() {
        Integer val = 0;
        for(int i = 0; i < 100; i++)
            val++;
        System.out.println(id + " " +
                Thread.currentThread().getName() + " " + val);
        return val;
    }
}


public class CachedThreadPool {
    public static Integer extractResult(Future<Integer> f) {
        try {
            return f.get();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args)throws InterruptedException {
        ExecutorService exec =
                Executors.newCachedThreadPool();
        List<CountingTask> tasks =
                IntStream.range(0, 10)
                        .mapToObj(CountingTask::new)
                        .collect(Collectors.toList());
        List<Future<Integer>> futures =
                exec.invokeAll(tasks);   //执行这里的时候会对所有线程进行执行，执行完毕后才会返回相应的Future结果集。
        Integer sum = futures.stream()
                .map(CachedThreadPool::extractResult)
                .reduce(0, Integer::sum);
        System.out.println("sum = " + sum);
        exec.shutdown();
    }
}
