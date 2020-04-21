package generics.common;

/**
 * @Author: shenge
 * @Date: 2020-04-17 10:55
 *
 * 通配符的使用。
 * 为什么不能add：因为编译器不是那么智能，它只会把flist当成具体的某一个Fruit类型的子类（具体），
 * 它也不知道是多少代的子类，你如果随便送的话编译器也不知道你送的这个是否能向上转型就会报错。
 *
 * 反之，super就可以、
 */
import java.util.*;

class Fruit {}

class Apple extends Fruit {}

class Jonathan extends Apple {}

class Orange extends Fruit {}

public class GenericsAndCovariance {

    public static void main(String[] args) {
        // Wildcards allow covariance:
        List<? extends Fruit> flist = new ArrayList<>();
//        Fruit fruit = flist.get(0);
        // Compile Error: can't add any type of object:
        // flist.add(new Apple());
        // flist.add(new Fruit());
        // flist.add(new Object());
        flist.add(null); // Legal but uninteresting
        // We know it returns at least Fruit:
        Fruit f = flist.get(0);

        List<? super Apple> slist = new ArrayList<>();
        slist.add(new Apple());
    }

}
