package generics.clean;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author: shenge
 * @Date: 2020-04-16 17:18
 *
 * 在泛型中创建数组。
 */
public class ArrayMaker<T> {
    private Class<T> kind;

    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }

    @SuppressWarnings("unchecked")
    T[] create(int size) {
        System.out.println(kind.getName());
        return (T[]) Array.newInstance(kind, size);
    }

    public static void main(String[] args) {
        ArrayMaker<String> stringMaker = new ArrayMaker<>(String.class);
        String[] stringArray = stringMaker.create(9);
        System.out.println(Arrays.toString(stringArray));
    }
}
