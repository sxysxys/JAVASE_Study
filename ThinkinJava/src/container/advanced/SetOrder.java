package container.advanced;

import container.advanced.HTMLColors;

import java.util.*;

/**
 * @Author: shenge
 * @Date: 2020-04-19 00:50
 *
 * 使用反射动态创建Set对象。
 */
public class SetOrder {
    static String[] sets = {
            "java.util.HashSet",
            "java.util.TreeSet",
            "java.util.concurrent.ConcurrentSkipListSet",
            "java.util.LinkedHashSet",
            "java.util.concurrent.CopyOnWriteArraySet",
    };
    static final List<String> RLIST =
            new ArrayList<>(HTMLColors.LIST);
    static {
        Collections.reverse(RLIST);
    }
    public static void
    main(String[] args) throws Exception {
        for(String type: sets) {
            System.out.format("[-> %s <-]%n",
                    type.substring(type.lastIndexOf('.') + 1));
            @SuppressWarnings("unchecked")
            Set<String> set = (Set<String>)
                    Class.forName(type).newInstance();
            set.addAll(RLIST);
            set.stream()
                    .limit(10)
                    .forEach(System.out::println);
        }
    }
}
