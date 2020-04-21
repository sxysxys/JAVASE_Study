package stream.optional;

import java.util.Optional;

/**
 * @Author: shenge
 * @Date: 2020-04-09 19:32
 *
 * 创造optional的几种方式。
 */
public class CreatingOptionals {
    static void test(String testName, Optional<String> opt) {
        System.out.println(" === " + testName + " === ");
        System.out.println(opt.orElse("Null"));
    }
    public static void main(String[] args) {
        test("empty", Optional.empty());
        test("of", Optional.of("Howdy"));
        try {
            Optional<String> opt = Optional.of(null);    //这就是直接返回一个null。
            test("of", opt);
        } catch(Exception e) {
            System.out.println(e);
        }
        test("ofNullable", Optional.ofNullable("Hi"));   //如果为null创建一个empty的optional。
        test("ofNullable", Optional.ofNullable(null));
    }
}