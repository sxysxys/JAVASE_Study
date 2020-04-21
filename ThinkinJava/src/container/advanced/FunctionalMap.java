package container.advanced;

import java.util.Map;

import static container.advanced.HTMLColors.MAP;

/**
 * @Author: shenge
 * @Date: 2020-04-19 09:23
 *
 * 使用流处理map，此时需要使用未绑定方法。
 */

public class FunctionalMap {
    public static void main(String[] args) {
        MAP.entrySet().stream().
                map(Map.Entry::getValue)   //使用未绑定方法。
                .filter(v->v.startsWith("Dark")).map(v->v.replaceFirst("Dark","Hot"))
                .forEach(System.out::println);
    }
}
