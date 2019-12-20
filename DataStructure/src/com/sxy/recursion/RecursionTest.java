package com.sxy.recursion;

public class RecursionTest {
    public static void main(String[] args) {
        test2(4);
        System.out.println("----------");
        test1(4);
    }

    /**
     * 不加else
     * @param n
     */
    public static void test1(int n){
        if (n>2){
            test1(n-1);
        }
        System.out.printf("n=%d\n",n);
    }

    /**
     * 加了else
     * @param n
     */
    public static void test2(int n){
        if (n>2){
            test2(n-1);
        }else {
            System.out.printf("n=%d\n",n);
        }
    }
}
