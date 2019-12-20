package com.sxy.recursion;

import java.lang.reflect.Array;

public class Queen8 {

    //定义一个max表示多少个皇后。
    int max=8;
    int array[] =new int[max];
    static int count=0;
    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.printf("最终的答案有%d种\n",count);
    }

    /**
     * 用于判断当放入第n个数的时候是否和前n-1个数冲突。
     * @return
     */
    public boolean judge(int n){
        for (int i = 0; i < n; i++) {
            if (array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])){  //列不相等，对角线不相等。
                return false;
            }
        }
        return true;
    }

    /**
     *编写一个方法，放置第n个皇后。
     */
    public void check(int n){
        if (n==max){  //8个皇后已经放好。
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突。
        for (int i = 0; i < max; i++) {
            array[n]=i;
            if (judge(n)){
                check(n+1);
            }
        }
    }
    //将相应的数组进行打印，每一位对应哪一行，值代表第几列。
    public void print(){
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
