package generics.group;

/**
 * @Author: shenge
 * @Date: 2020-04-15 19:37
 *
 * 元组的概念。
 */
public class Tuple2<A, B> {
    public final A a1;
    public final B a2;
    public Tuple2(A a, B b) { a1 = a; a2 = b; }
    public String rep() { return a1 + ", " + a2; }

    @Override
    public String toString() {
        return "(" + rep() + ")";
    }
}


