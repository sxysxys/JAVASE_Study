package stream;

import java.util.stream.Stream;

/**
 * @Author: shenge
 * @Date: 2020-04-09 15:51
 *
 * 通过构造方法进行map映射
 */

class Numbered{
    final int n;
    public Numbered(int n) {
        this.n=n;
    }

    @Override
    public String toString() {
        return "Numbered{" +
                "n=" + n +
                '}';
    }
}
public class FunctionMap {
    public static void main(String[] args) {
        Stream.of(1,2,3,4,5)
                .map(Numbered::new)
                .forEach(System.out::println);
    }
}
