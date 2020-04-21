package container;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: shenge
 * @Date: 2020-04-05 10:01
 */

class Pet {
    @Override
    public String toString() {
        return "Pet:"+hashCode();
    }
};

class Cat extends Pet {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public Cat(){};

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
};

class Dog extends Pet {
};

public class ListApi {
    public static void main(String[] args) {

        List<Pet> pets = new ArrayList<>();
        pets.add(new Cat());
        pets.add(new Dog());
        pets.add(new Cat());
        pets.add(new Dog());

        //不管是indexof还是remove这种需要将对象引用作为参数传入的方法，都需要调用equals()。

        Cat cat = new Cat();
        System.out.println("创建新对象输出的结果为:" + pets.indexOf(cat));

        Cat cat1 = (Cat) pets.get(0);
        System.out.println("get后得到的对象输出的结果为:" + pets.indexOf(cat1));

        //也就是说，List中如果是对象，那么equals是通过引用是否为同一个对象来判断的。


        //其他的还是通过equals来确定引用。

        Object[] objects = pets.toArray();

        //使用如下进行类型转换，不能直接在前面加强制类型。其中2代表带表初始給2，他自己会根据实际情况扩充。

//        Pet[] pets1 = pets.toArray(new Pet[2]);

        System.out.println("get后得到的对象输出的结果为:" + pets.indexOf(objects[1]));

        List<Cat> cats = Arrays.asList(cat, cat1);

        pets.retainAll(cats);

        System.out.println(pets.size());


        System.out.println("-------------");


        ArrayList<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        strings.add("e");
        strings.add("f");
        System.out.println("get后得到的对象输出的结果为:" + strings.indexOf("b"));  //通过equals来判断的。
        System.out.println("contains后得到的对象输出的结果为:" + strings.contains("b"));

        System.out.println("-------------");

        //不同的对象hashcode不一样的。
        System.out.println(new Cat().hashCode());
        System.out.println(new Cat().hashCode());
        System.out.println(new Cat().hashCode());

        System.out.println("-------------");

        //对对象使用set的时候，需要重写hashcode和equals方法。
        HashSet<Cat> cats1 = new HashSet<>();
        cats1.add(new Cat("1hao"));
        cats1.add(new Cat("1hao"));
        cats1.add(new Cat("1hao"));
        cats1.add(new Cat("1hao"));
        System.out.println(cats1.size());

    }
}
