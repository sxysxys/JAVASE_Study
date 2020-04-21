package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Author: shenge
 * @Date: 2020-04-17 17:34
 */
class FixedSizeStack<T> {
    private final int size;
    private Object[] storage;
    private int index = 0;

    FixedSizeStack(int size) {
        this.size = size;
        storage = new Object[size];
    }

    public void push(T item) {
        if (index < size)
            storage[index++] = item;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        return index == 0 ? null : (T) storage[--index];
    }

    @SuppressWarnings("unchecked")
    Stream<T> stream() {
        return (Stream<T>) Arrays.stream(storage);  //为什么可以这样？  因为编译期所有泛型会被擦除，所以无泛型肯定可以强转成泛型。
    }

}
public class GenericCast {
    static String[] letters = "ABCDEFGHIJKLMNOPQRS".split("");

    public static void main(String[] args) {
        FixedSizeStack<String> strings =
                new FixedSizeStack<>(letters.length);
        Arrays.stream("ABCDEFGHIJKLMNOPQRS".split(""))
                .forEach(strings::push);
        System.out.println(strings.pop());
        strings.stream()
                .map(s -> s + " ")
                .forEach(System.out::print);
    }
}
