package stream.streamend;

/**
 * @Author: shenge
 * @Date: 2020-04-09 22:37
 *
 * 终端操作：collector构造器将流中的元素放入TreeSet中。
 * 将集合作为终端。
 */
import java.util.*;
import java.nio.file.*;
import java.util.stream.*;
public class TreeSetOfWords {
    public static void
    main(String[] args) throws Exception {
        Set<String> words2 =
                Files.lines(Paths.get("TreeSetOfWords.java"))
                        .flatMap(s -> Arrays.stream(s.split("\\W+")))
                        .filter(s -> !s.matches("\\d+")) // No numbers
                        .map(String::trim)
                        .filter(s -> s.length() > 2)
                        .limit(100)
                        .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(words2);
    }
}