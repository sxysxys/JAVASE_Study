package container;

import java.util.AbstractList;
import java.util.List;

/**
 * @Author: shenge
 * @Date: 2020-04-19 18:47
 *
 * 实现自己的list。
 *
 * 默认通过get拿到元素，通过size判断元素个数。
 */


public class CountingIntegerList extends AbstractList<Integer> {

    private int size;

    public CountingIntegerList(int size) {
        this.size = size < 0 ? 0 : size;
    }

    @Override
    public Integer get(int index) {
        return index;
    }

    @Override
    public int size() {
        return this.size;
    }

    public static void main(String[] args) {
        List<Integer> integers = new CountingIntegerList(30);
        System.out.println(integers);
        System.out.println(integers.get(500));
    }
}
