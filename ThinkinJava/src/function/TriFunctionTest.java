package function;

/**
 * @Author: shenge
 * @Date: 2020-04-08 11:19
 *
 * 泛型定义接口。
 */
@FunctionalInterface
interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}

public class TriFunctionTest {
    static int f(int i, long l, double d) { return 99; }
    public static void main(String[] args) {
        TriFunction<Integer, Long, Double, Integer> tf =
                TriFunctionTest::f;
        tf = (i, l, d) -> 12;
    }
}
