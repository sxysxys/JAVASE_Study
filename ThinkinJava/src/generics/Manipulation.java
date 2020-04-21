package generics;

/**
 * @Author: shenge
 * @Date: 2020-04-16 10:31
 *
 * 用来测试的类。
 */


class HasF {
    public void f() {
        System.out.println("HasF.f()");
    }
}

class Manipulator<T> {
    private T obj;

    Manipulator(T x) {
        obj = x;
    }

    // Error: cannot find symbol: method f():
    public void manipulate() {
    }

}

public class Manipulation {
    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<>(hf);
        manipulator.manipulate();
    }
}
