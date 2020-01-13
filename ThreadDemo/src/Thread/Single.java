package Thread;

/**
 * 懒汉式单例设计模式
 * 会有很明显的线程不同步现象
 * 如果直接在getInstance方法上加synchronized，那么极大降低性能，每一次取出对象都要判断锁。
 *
 */
public class Single {
    private static Single s=null;
    private Single(){};
    public static Single getInstance(){
        if (s==null){
            synchronized (Single.class) {
                if (s==null)
                s = new Single();
            }
        }
        return s;
    }
}

/**
 * 饿汉式单例设计模式
 * 没有线程安全问题。
 */
class Singlee{
    private static final Singlee s=new Singlee();
    private Singlee(){};
    public static Singlee getInstance(){
        return s;
    }
}
