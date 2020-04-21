package stream.streamend;

/**
 * @Author: shenge
 * @Date: 2020-04-09 23:36
 *
 * 将匹配当做终端。
 * 使用了未绑定方法的设计方式。
 *
 */
import java.util.stream.*;
import java.util.function.*;

interface Matcher extends BiPredicate<Stream<Integer>, Predicate<Integer>> {}

public class Matching {
    static void show(Matcher match, int val) {
        System.out.println(
                match.test(
                        IntStream.rangeClosed(1, 9)
                                .boxed()
                                .peek(n -> System.out.format("%d ", n)),   //可以当做未绑定方法的使用，这是将方法的第一个参数当做了Stream对象的引用。
                        n -> n < val));
    }
    public static void main(String[] args) {
        show(Stream::allMatch, 10);
        show(Stream::allMatch, 4);
        show(Stream::anyMatch, 2);
        show(Stream::anyMatch, 0);
        show(Stream::noneMatch, 5);
        show(Stream::noneMatch, 0);
    }
}
