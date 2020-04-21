package function;

import java.util.function.Function;

/**
 * @Author: shenge
 * @Date: 2020-04-08 15:05
 */
interface
FuncSS extends Function<String, String> {} // [1]

public class ProduceFunction {
    static FuncSS produce() {
        return s -> s.toLowerCase(); // [2]
    }
    public static void main(String[] args) {
        FuncSS f = produce();
        System.out.println(f.apply("YELLING"));
    }
}
