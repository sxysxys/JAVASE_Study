package thread;

import java.util.Timer;
import java.util.concurrent.CompletableFuture;

/**
 * @Author: shenge
 * @Date: 2020-04-21 14:06
 *
 * CompletableFuture的用法：封装对象，顺序执行，并且可以开辟异步线程。
 */
class Machina {
    public enum State {
        START, ONE, TWO, THREE, END;
        State step() {
            if(equals(END))
                return END;
            return values()[ordinal() + 1];
        }
    }
    private State state = State.START;
    private final int id;
    public Machina(int id) {
        this.id = id;
    }
    public static Machina work(Machina m) {
        if(!m.state.equals(State.END)){
            new Nap(0.1);
            m.state = m.state.step();
        }
        System.out.println(m);
        return m;
    }
    @Override
    public String toString() {
        return"Machina" +Thread.currentThread().getName()+ id + ": " + (state.equals(State.END)? "complete" : state);
    }
}

public class CompletableApply {
    public static void main(String[] args) {
//        CompletableFuture<Machina> cf =
//                CompletableFuture.completedFuture(
//                        new Machina(0));
//        CompletableFuture<Machina> cf2 =
//                cf.thenApply(Machina::work);
//        CompletableFuture<Machina> cf3 =
//                cf2.thenApply(Machina::work);
//        CompletableFuture<Machina> cf4 =
//                cf3.thenApply(Machina::work);
//        CompletableFuture<Machina> cf5 =
//                cf4.thenApply(Machina::work);

//        Timer timer = new Timer();
        CompletableFuture<Machina> cf1 =
                CompletableFuture.completedFuture(
                        new Machina(0))
                        .thenApply(Machina::work)
                        .thenApply(Machina::work)
                        .thenApply(Machina::work)
                        .thenApply(Machina::work);  //调用的是main线程，一直顺序执行下去。

        CompletableFuture<Machina> cf =
                CompletableFuture.completedFuture(
                        new Machina(0))
                        .thenApplyAsync(Machina::work)
                        .thenApplyAsync(Machina::work)
                        .thenApplyAsync(Machina::work)
                        .thenApplyAsync(Machina::work);   //调用了另外一个线程。
        System.out.println(cf.join());  //等待cf线程执行完。
    }
}

