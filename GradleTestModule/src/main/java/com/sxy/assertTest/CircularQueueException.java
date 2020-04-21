package com.sxy.assertTest;
/**
 *  @Author: shenge
 *  @Date: 2020-04-11 17:16
 *
 *  构造一个自定义异常。
 */
public class CircularQueueException extends RuntimeException {
    public CircularQueueException(String why) {
        super(why);
    }
}
