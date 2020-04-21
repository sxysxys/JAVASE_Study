package com.sxy.assertTest;

/**
 * @Author: shenge
 * @Date: 2020-04-11 16:38
 *
 * 默认开启断言。以断言的方式执行。
 */
public class LoaderAssertions {
    public static void main(String[] args) {

        ClassLoader.getSystemClassLoader().
                setDefaultAssertionStatus(true);
        new Loaded().go();
    }
}

class Loaded {
    public void go() {
        assert false: "Loaded.go()";
    }
}