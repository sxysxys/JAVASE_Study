package com.sxy.assertTest;

/**
 * @Author: shenge
 * @Date: 2020-04-11 16:31
 *
 * 默认情况下执行会忽视断言
 * 在vm参数中配置-ea即可。
 */
public class Assert1 {

    public static void main(String[] args) {
        assert false:
                "Here's a message saying what happened";
    }
}
