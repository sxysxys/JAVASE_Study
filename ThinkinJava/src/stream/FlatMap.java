package stream;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author: shenge
 * @Date: 2020-04-09 16:01
 *
 * 通过map映射到不同类型。
 * 测试flatMap使用。
 */
public class FlatMap {
    static Random rand = new Random(47);
    public static void main(String[] args) {
        //通过map正常转。
        Stream.of("1","2","3")
                .map(Integer::parseInt)
                .forEach(n->System.out.format("%d ", n));

        //通过mapToInt转成IntStream，从而使用更多的整数操作方法。
        Stream.of("1","2","3")
                .mapToInt(Integer::parseInt)
                .forEach(n->System.out.format("%d ", n));

        //map返回的是流一个个流对象。
        Stream.of(1, 2, 3)
                .map(i -> Stream.of("Gonzo", "Kermit", "Beaker"))
                .map(e-> e.getClass().getName())
                .forEach(System.out::println);

        //flatMap返回的是流里面的对象，自动扁平化。
        Stream.of(1, 2, 3)
                .flatMap(i->Stream.of("Gonzo", "Fozzie", "Beaker"))
                .forEach(System.out::println);

        //通过flatMap将两个流进行拼接，并且统一扁平化输出。
        Stream.of(1, 2, 3, 4, 5)
                .flatMapToInt(i -> IntStream.concat(
                        rand.ints(0, 100).limit(i), IntStream.of(-1)))  //统一进行转化成intStream里的元素。
                .forEach(n -> System.out.format("%d ", n));
    }
}
