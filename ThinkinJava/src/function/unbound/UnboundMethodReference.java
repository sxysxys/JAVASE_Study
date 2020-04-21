package function.unbound;

/**
 * @Author: shenge
 * @Date: 2020-04-08 09:52
 *
 * 通过传递参数的形式绑定上其他对象的方法。
 */
class X {
    String f() { return "X::f()"; }
}

interface MakeString {
    String make();
}

interface TransformX {
    String transform(X x);
}

public class UnboundMethodReference {
    public static void main(String[] args) {
//         MakeString ms = X::f; // [1]
        TransformX sp = X::f;
        X x = new X();
        System.out.println(sp.transform(x)); // [2]
        System.out.println(x.f()); // 同等效果
    }
}
