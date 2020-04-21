package container;

/**
 * @Author: shenge
 * @Date: 2020-04-19 22:11
 *
 * Set的几种不同。
 */
import java.util.*;
import java.util.function.*;
import java.util.Objects;

class SetType {
    protected int i;
    SetType(int n) { i = n; }
    @Override
    public boolean equals(Object o) {
        return o instanceof SetType &&
                Objects.equals(i, ((SetType)o).i);
    }
    @Override
    public String toString() {
        return Integer.toString(i);
    }
}

class HashType extends SetType {
    HashType(int n) { super(n); }
    @Override
    public int hashCode() {
        return Objects.hashCode(i);
    }
}

class TreeType extends SetType
        implements Comparable<TreeType> {
    TreeType(int n) { super(n); }
    @Override
    public int compareTo(TreeType arg) {
        return Integer.compare(arg.i, i);
        // Equivalent to:
        // return arg.i < i ? -1 : (arg.i == i ? 0 : 1);
    }
}

public class TypesForSets {
    static <T> void
    fill(Set<T> set, Function<Integer, T> type) {
        for(int i = 10; i >= 5; i--) // Descending
            set.add(type.apply(i));
        for(int i = 0; i < 5; i++) // Ascending
            set.add(type.apply(i));
    }
    static <T> void
    test(Set<T> set, Function<Integer, T> type) {
        fill(set, type);
        fill(set, type); // Try to add duplicates
        fill(set, type);
        System.out.println(set);
    }
    public static void main(String[] args) {
        test(new HashSet<>(), HashType::new);
        test(new LinkedHashSet<>(), HashType::new);
        test(new TreeSet<>(), TreeType::new);
        // Things that don't work:
        test(new HashSet<>(), SetType::new);
        test(new HashSet<>(), TreeType::new);
        test(new LinkedHashSet<>(), SetType::new);
        test(new LinkedHashSet<>(), TreeType::new);
        try {
            test(new TreeSet<>(), SetType::new);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            test(new TreeSet<>(), HashType::new);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
