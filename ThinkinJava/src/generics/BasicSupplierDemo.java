package generics;

/**
 * @Author: shenge
 * @Date: 2020-04-15 22:36
 *
 * 泛型方法使用：确定相应的T。
 * 1. 传入CountedObject.class的时候相当于指定了Supplier<T>的T的类型为CountedObject。
 * 2. 也就指定了BasicSupplier<T>中的T的类型。
 *
 *
 */
import java.util.function.Supplier;
import java.util.stream.Stream;

class CountedObject {
    private static long counter = 0;
    private final long id = counter++;

    public long id() {
        return id;
    }

    @Override
    public String toString() {
        return "CountedObject " + id;
    }
}

class BasicSupplier<T> implements Supplier<T> {
    private Class<T> type;

    public BasicSupplier(Class<T> type) {
        this.type = type;
    }

    @Override
    public T get() {
        try {
            // Assumes type is a public class:
            return type.newInstance();
        } catch (InstantiationException |
                IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    // Produce a default Supplier from a type token:
    public static <T> Supplier<T> create(Class<T> type) {
        return new BasicSupplier<>(type);
    }
}

public class BasicSupplierDemo {
    public static void main(String[] args) {
        Stream.generate(
                BasicSupplier.create(CountedObject.class))
                .limit(5)
                .forEach(System.out::println);
    }
}
