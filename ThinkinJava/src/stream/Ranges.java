package stream;

import java.util.stream.IntStream;

/**
 * @Author: shenge
 * @Date: 2020-04-09 09:45
 * 通过流实现10-20之间的数相加。
 */
public class Ranges {
    public static void main(String[] args) {
        System.out.println(IntStream.range(10,20).sum());
    }
}
