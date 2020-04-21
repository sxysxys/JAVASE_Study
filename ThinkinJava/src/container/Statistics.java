package container;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Author: shenge
 * @Date: 2020-04-06 21:15
 *
 * 通过map测试random的随机化。
 */
public class Statistics {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Map<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i < 10000; i++) {
            // Produce a number between 0 and 20:
            int r = rand.nextInt(20);
            Integer freq = m.get(r); // [1]
            m.put(r, freq == null ? 1 : freq + 1);
        }
        System.out.println(m);

    }


}
