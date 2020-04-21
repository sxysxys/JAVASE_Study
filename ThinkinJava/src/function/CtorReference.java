package function;

/**
 * @Author: shenge
 * @Date: 2020-04-08 10:25
 * <p>
 * 使用构造方法来绑定方法。
 */

class Dog {
    String name;
    int age = -1;

    Dog() {
        System.out.println("第一个构造方法执行");
        name = "一个参数都没有奥";
    }

    Dog(String name) {
        this.name = name;
    }

    Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

interface MakeNoArgs {
    Dog make();
}

interface MakeOneArg {
    Dog make(String name);
}

interface MakeTwoArgs {
    Dog make(String name, int age);
}

public class CtorReference {
    public static void main(String[] args) {
        MakeNoArgs makeNoArgs=Dog::new;
        MakeOneArg makeOneArg=Dog::new;
        MakeTwoArgs makeTwoArgs=Dog::new;
        Dog make = makeNoArgs.make();
        Dog make1 = makeOneArg.make("123");
        Dog wefw = makeTwoArgs.make("wefw", 12);
    }
}
