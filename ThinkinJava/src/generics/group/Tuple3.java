package generics.group;

import generics.group.Tuple2;

/**
 * @Author: shenge
 * @Date: 2020-04-15 19:38
 *
 * 继承元组。
 */
public class Tuple3<A, B, C> extends Tuple2<A, B> {
    public final C a3;
    public Tuple3(A a, B b, C c) {
        super(a, b);
        a3 = c;
    }

    @Override
    public String rep() {
        return super.rep() + ", " + a3;
    }
}
