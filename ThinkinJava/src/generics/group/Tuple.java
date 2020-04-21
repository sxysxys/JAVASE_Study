package generics.group;

/**
 * @Author: shenge
 * @Date: 2020-04-15 23:38
 *
 * 泛型方法使用：赋值时初始化A、B
 */
public class Tuple {
    public static <A, B> Tuple2<A, B> tuple(A a, B b) {
        return new Tuple2<>(a, b);
    }

    public static <A, B, C> Tuple3<A, B, C> tuple(A a, B b, C c) {
        return new Tuple3<>(a, b, c);
    }
}
