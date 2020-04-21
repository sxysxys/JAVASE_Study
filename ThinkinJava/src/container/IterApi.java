package container;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: shenge
 * @Date: 2020-04-06 19:43
 */
public class IterApi {
    public static void main(String[] args) {
        List<Pet> pets = new ArrayList<>();
        pets.add(new Cat());
        pets.add(new Dog());
        pets.add(new Cat());
        pets.add(new Dog());

        //stack底层使用的是vector数据结构，而且没有办法改变，因为java1.0的设计失误。
        Stack<String> strings = new Stack<>();

        //事实证明，依旧还是引用。。

        LinkedList<Pet> pets1 = new LinkedList<>(pets);
        Dog cat = (Dog)pets1.get(1);
        System.out.println("get后得到的对象输出的结果为:" + pets.indexOf(cat));
    }
}
