package container;

import java.util.Arrays;

/**
 * @Author: shenge
 * @Date: 2020-04-07 00:15
 */
public class ArrayIsNotIterable {
    static <T> void test(Iterable<T> ib) {
        for(T t : ib)
            System.out.print(t + " ");
    }
    public static void main(String[] args) {
        test(Arrays.asList(1, 2, 3));
        String[] strings = { "A", "B", "C" };
        // An array works in for-in, but it's not Iterable:
//        assertTest(strings);
        // You must explicitly convert it to an Iterable:
        test(Arrays.asList(strings));
    }
}
