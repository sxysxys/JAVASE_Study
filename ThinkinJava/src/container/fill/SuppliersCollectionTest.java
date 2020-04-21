package container.fill;

import tools.Suppliers;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 * @Author: shenge
 * @Date: 2020-04-19 11:22
 *
 * 使用Stream填充容器。
 */
class Government implements Supplier<String> {
    static String[] foundation = (
            "strange women lying in ponds " +
                    "distributing swords is no basis " +
                    "for a system of government").split(" ");
    private int index;
    @Override
    public String get() {
        return foundation[index++];
    }
}

public class SuppliersCollectionTest {
    public static void main(String[] args) {
        // Suppliers class from the Generics chapter:
        Set<String> set = Suppliers.create(
                LinkedHashSet::new, new Government(), 15);
        System.out.println(set);
        List<String> list = Suppliers.create(
                LinkedList::new, new Government(), 15);
        System.out.println(list);
        list = new ArrayList<>();
        Suppliers.fill(list, new Government(), 15);
        System.out.println(list);

        // Or we can use Streams:
        set = Arrays.stream(Government.foundation)
                .collect(Collectors.toSet());  //散列填充是乱序的。
        System.out.println(set);
        list = Arrays.stream(Government.foundation)
                .collect(Collectors.toList());
        System.out.println(list);
        list = Arrays.stream(Government.foundation)
                .collect(Collectors
                        .toCollection(LinkedList::new));
        System.out.println(list);
        set = Arrays.stream(Government.foundation)
                .collect(Collectors
                        .toCollection(LinkedHashSet::new));    //顺序的，维护一个链表来保存顺序。
        System.out.println(set);
    }
}
