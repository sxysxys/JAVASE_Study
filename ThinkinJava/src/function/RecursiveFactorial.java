package function;

/**
 * @Author: shenge
 * @Date: 2020-04-07 22:56
 * <p>
 * 使用lambder表达式进行递归计算。
 */

interface IntCall {
    int call(int arg);
}

public class RecursiveFactorial {

    static IntCall intCall;

    public static void main(String[] args) {
        intCall = arg -> arg == 0 ? 1 : arg * intCall.call(arg-1);
        for (int i = 0; i < 10; i++) {
            System.out.println(intCall.call(i));
        }
    }
}
