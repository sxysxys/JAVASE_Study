package interfaces;

/**
 * @Author: shenge
 * @Date: 2020-04-02 11:15
 *
 * 接口命名冲突
 */
interface I1 {
    void f();
}

interface I2 {
    int f(int i);
}

interface I3 {
    int f();
}

class C {
    public int f() {
        return 1;
    }
}

class C2 implements I1, I2 {
    @Override
    public void f() {}

    @Override
    public int f(int i) {
        return 1;  // 重载
    }
}

class C3 extends C implements I2 {
    @Override
    public int f(int i) {
        return 1; // 重载
    }
}

class C4 extends C implements I3 {
    // 完全相同，没问题
    @Override
    public int f() {
        return 1;
    }
}

// 方法的返回类型不同，这里会出问题，默认是重写（参数一样），但是返回值和接口定义的不一样。
//class C5 extends C implements I1 {}
//- interface I4 extends I1, I3 {}
