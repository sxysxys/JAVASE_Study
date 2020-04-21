package container.fill;

/**
 * @Author: shenge
 * @Date: 2020-04-19 10:52
 *
 * 使用Collections中的方法填充集合。
 */
import java.util.*;

class StringAddress {
    private String s;
    StringAddress(String s) { this.s = s; }
    @Override
    public String toString() {
        return super.toString() + " " + s;
    }
}

public class FillingLists {
    public static void main(String[] args) {
        List<StringAddress> list = new ArrayList<>(
                Collections.nCopies(4,
                        new StringAddress("Hello")));   //所有引用都指向同一个对象。
        System.out.println(list);
        Collections.fill(list,
                new StringAddress("World!"));    //用指定的元素替换列表中所有存在的元素。
        System.out.println(list);
    }
}
