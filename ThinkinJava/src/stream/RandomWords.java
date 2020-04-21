package stream;

/**
 * @Author: shenge
 * @Date: 2020-04-09 09:31
 */
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.io.*;
import java.nio.file.*;
public class RandomWords implements Supplier<String> {   //提供流的接口。
    List<String> words = new ArrayList<>();
    Random rand = new Random(47);
    RandomWords(String fname) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fname));
        // 略过第一行
        for (String line : lines.subList(1, lines.size())) {
            for (String word : line.split("[ .?,]+"))
                words.add(word.toLowerCase());
        }
    }
    public String get() {
        return words.get(rand.nextInt(words.size()));
    }
    @Override
    public String toString() {
        return words.stream()
                .collect(Collectors.joining(" "));    //collect将传入的流元素通过括号里的方法进行收集。
    }
    public static void main(String[] args) throws Exception {
        System.out.println(
                Stream.generate(new RandomWords("Cheese.dat"))   //其中放入Supplier接口，会自动将T(Stream)转换成流。
                        .limit(10)
                        .collect(Collectors.joining(" ")));
    }
}
