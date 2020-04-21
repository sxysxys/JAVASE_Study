package function;

import java.util.function.Function;

/**
 * @Author: shenge
 * @Date: 2020-04-08 15:24
 *
 * lambda接口的函数构造。
 * andthen:将两个函数的动作结合起来。
 */
class I {
    @Override
    public String toString() { return "I"; }
}

class O {
    @Override
    public String toString() { return "O"; }
}

public class TransformFunction {
    static Function<I,O> transform(Function<I,O> in) {
        return in.andThen(o -> {   //括号里定义了要拿到第一个函数返回的结果继续做什么，是第二个动作。
            System.out.println(o);
            return o;
        });
    }
    public static void main(String[] args) {
        Function<I,O> f2 = transform(i -> {
            System.out.println(i);
            return new O();       //第一个动作，将返回的结果给到了andthen
        });
        O o = f2.apply(new I());
    }
}
