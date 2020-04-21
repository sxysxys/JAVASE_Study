package generics.clean;

/**
 * @Author: shenge
 * @Date: 2020-04-16 19:51
 *
 * 这种方式创建对象。
 */
abstract class GenericWithCreate<T> {
    final T element;

    GenericWithCreate() {
        element = create();
    }

    abstract T create();
}

class X {
}

class XCreator extends GenericWithCreate<X> {
    @Override
    X create() {   //正常应该得返回Object才能实现重写，这时编译器会编译成object，然后强转。
        return new X();
    }

    void f() {
        System.out.println(
                element.getClass().getSimpleName());
    }
}

public class CreatorGeneric {
    public static void main(String[] args) {
        XCreator xc = new XCreator();
        xc.f();
    }
}