package stream;

import java.util.stream.Stream;

/**
 * @Author: shenge
 * @Date: 2020-04-09 10:23
 *
 * 通过lambda表达式给supplier赋值，再通过foreach进行遍历。
 */
class Bubble{

    public final int i;

    public Bubble(int a) {
        i=a;
    }

    public static int count=0;

    @Override
    public String toString() {
        return "Bubble{" +
                "i=" + i +
                '}';
    }

    public static Bubble bubble(){
        return new Bubble(count++);
    }
}
public class Bubbles {
    public static void main(String[] args) {
        Stream.generate(Bubble::bubble)  //产生无限的流。
                .limit(5).forEach(System.out::println);
    }
}
