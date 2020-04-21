package container.fill;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: shenge
 * @Date: 2020-04-19 18:14
 */
class Letters
        implements Supplier<Pair<Integer,String>> {
    private int number = 1;
    private char letter = 'A';
    @Override
    public Pair<Integer,String> get() {
        return new Pair<>(number++, "" + letter++);
    }
}

public class StreamFillMaps {
    public static void main(String[] args) {
        Map<Integer,String> m =
                Stream.generate(new Letters())
                        .limit(11)
                        .collect(Collectors
                                .toMap(Pair::key, Pair::value));
        System.out.println(m);
    }
}
