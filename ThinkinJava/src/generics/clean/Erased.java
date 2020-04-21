package generics.clean;

/**
 * @Author: shenge
 * @Date: 2020-04-16 18:42
 *
 * 由于泛型的类型擦除，导致无法获取类型信息。
 */
public class Erased<T> {
    private final int SIZE = 100;

    public void f(Object arg) {
        // error: illegal generic type for instanceof
//        if (arg instanceof T) {
//        }
        // error: unexpected type
//        T var = new T();
        // error: generic array creation
//        T[] array = new T[SIZE];
        // warning: [unchecked] unchecked cast
//        T[] array = (T[]) new Object[SIZE];

    }
}
