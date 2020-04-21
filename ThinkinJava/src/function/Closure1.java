package function;

import java.util.function.IntSupplier;

/**
 * @Author: shenge
 * @Date: 2020-04-08 16:07
 */
public class Closure1 {
    int i;
    IntSupplier makeFun(int x) {
        return () -> x + i++;
    }
}