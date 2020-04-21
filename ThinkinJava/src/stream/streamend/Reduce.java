package stream.streamend;

/**
 * @Author: shenge
 * @Date: 2020-04-09 23:22
 *
 * 测试reduce的使用。
 * 将reduce和ifpresent作为终端。
 */
// streams/Reduce.java
import java.util.*;
import java.util.stream.*;
class Frobnitz {
    int size;
    Frobnitz(int sz) { size = sz; }
    @Override
    public String toString() {
        return "Frobnitz(" + size + ")";
    }
    // Generator:
    static Random rand = new Random(47);
    static final int BOUND = 100;
    static Frobnitz supply() {
        return new Frobnitz(rand.nextInt(BOUND));
    }
}
public class Reduce {
    public static void main(String[] args) {
        Stream.generate(Frobnitz::supply)
                .limit(10)
                .peek(System.out::println)
                .reduce((fr0, fr1) -> fr0.size < 50 ? fr0 : fr1)  //一开始将前两个分别放入fr0和1，然后将结果返回fr0，一直迭代后输出最后那个结果，封装成Optional。
                .ifPresent(System.out::println);
    }
}