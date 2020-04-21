package stream;

import java.util.stream.LongStream;

import static java.util.stream.LongStream.rangeClosed;

/**
 * @Author: shenge
 * @Date: 2020-04-09 15:19
 *
 * 找出质数。
 */
public class Prime {
    public static Boolean isPrime(long n) {
        boolean b = rangeClosed(2, (long) Math.sqrt(n))
                .noneMatch(i -> n % i == 0);     //等于0的时候返回false;anyMatch的时候反过来。
        return b;
    }
    public LongStream numbers() {
        return LongStream.iterate(2, i -> i + 1)
                .filter(Prime::isPrime);    //filter进行判断条件，筛选流。
    }
    public static void main(String[] args) {
        new Prime().numbers()
                .limit(10)
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();
        new Prime().numbers()
                .skip(90)
                .limit(10)
                .forEach(n -> System.out.format("%d ", n));
    }
}