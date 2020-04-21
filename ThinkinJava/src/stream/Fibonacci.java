package stream;

import java.util.stream.Stream;

/**
 * @Author: shenge
 * @Date: 2020-04-09 10:51
 *
 * 迭代流产生斐波拉契数列。
 */
public class Fibonacci {
    int x = 1;

    Stream<Integer> numbers() {
        return Stream.iterate(0, i -> {   //0作为第一个i，每次返回的值作为下一个i。
            int result = x + i;
            x = i;
            return result;
        });
    }

    public static void main(String[] args) {
        new Fibonacci().numbers()
                .skip(20) // 过滤前 20 个
                .limit(10) // 然后取 10 个
                .forEach(System.out::println);
    }
}
