package generics.group;

import static generics.group.Tuple.tuple;

/**
 * @Author: shenge
 * @Date: 2020-04-15 23:39
 *
 * 对泛型方法进行测试。
 */
public class TupleTest2 {
    static Tuple2<String, Integer> f() {
        return tuple("hi", 47);  //一送进去就会再编译器进行检查。
    }

    static Tuple2 f2() {
        return tuple("hi", 47);  //可以认为是编译器自动进行了向上转型（泛型转啥也没有）。但是一旦用泛型引用来接受编译器就会警告。本质：泛型都是编译器搞出来的。
    }

    public static void main(String[] args) {
        Tuple2<String, Integer> ttsi = f();
//        Tuple2<String, Integer> ttsi1 = f2();
        System.out.println(ttsi);
        System.out.println(f2());

//        Class<String> xx= String.class;
    }
}
