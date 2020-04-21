package stream;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @Author: shenge
 * @Date: 2020-04-09 22:23
 */
class RandInts {
    private static int[] rints = new Random(47).ints(0, 10000).limit(8000).toArray();
    public static IntStream rands() {
        return Arrays.stream(rints);
    }
}

public class ForEach {
    static final int SZ = 14;
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        RandInts.rands().limit(SZ)
                .forEach(n -> System.out.format("%d ", n));
        long l1 = System.currentTimeMillis();
        System.out.println("时间："+(l1-l));
        long l2 = System.currentTimeMillis();
        RandInts.rands().limit(SZ)
                .parallel()
                .forEach(n -> System.out.format("%d ", n));
        long l3 = System.currentTimeMillis();
        System.out.println("时间："+(l3-l2));    //内部迭代，多核并行执行。
        RandInts.rands().limit(SZ)
                .parallel()
                .forEachOrdered(n -> System.out.format("%d ", n));
    }
}
