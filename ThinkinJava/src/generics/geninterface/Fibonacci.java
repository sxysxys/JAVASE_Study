package generics.geninterface;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @Author: shenge
 * @Date: 2020-04-15 21:53
 *
 * 接口泛型的应用：
 * 斐波拉契数列的实现。
 */
public class Fibonacci implements Supplier<Integer> {
    private int count = 0;
    @Override
    public Integer get() { return fib(count++); }

    private int fib(int n) {
        if(n < 2) return 1;
        return fib(n-2) + fib(n-1);
    }

    public static void main(String[] args) {
        Stream.generate(new Fibonacci())
                .limit(18)
                .map(n -> n + " ")
                .forEach(System.out::print);
    }
}
