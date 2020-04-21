package stream.optional;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author: shenge
 * @Date: 2020-04-09 17:36
 *
 * 测试空流返回optional。
 * optional就是防止流里面的元素不存在而设立的。
 */

public class OptionalsFromEmptyStreams {
    public static void main(String[] args) {
        System.out.println(Stream.<String>empty()   //正常情况下编译器会根据放入的数据自动识别Stream的类型，但是empty需要自己指定，就用这种语法格式。
                .findFirst());
        System.out.println(Stream.<String>empty()
                .findAny());
        System.out.println(Stream.<String>empty()
                .max(String.CASE_INSENSITIVE_ORDER));
        System.out.println(Stream.<String>empty()
                .min(String.CASE_INSENSITIVE_ORDER));
        System.out.println(Stream.<String>empty()
                .reduce((s1, s2) -> s1 + s2));
        System.out.println(IntStream.empty()
                .average());
    }
}
