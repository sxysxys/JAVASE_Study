package stream.optional;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @Author: shenge
 * @Date: 2020-04-09 17:44
 *
 * 测试optional。
 */
public class OptionalTest1 {

    static void test(Optional<String> optional){
        if (optional.isPresent()){
            System.out.println(optional.get());
        }else {
            System.out.println("Nothing on it");
        }
    }
    public static void main(String[] args) {
        test(Stream.of("123").findFirst());
        test(Stream.<String>empty().findFirst());
    }
}
