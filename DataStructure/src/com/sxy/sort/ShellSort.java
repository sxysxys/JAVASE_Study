package com.sxy.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
//        int[] arr={8,9,1,7,2,3,4,5,0,6};
        //创建数组
        int[] arr=new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i]=(int)(Math.random()*8000000);
        }
        long l = System.currentTimeMillis();
        shellMove(arr);
        long l1 = System.currentTimeMillis();
        long l2 = (l1 - l) ;
        System.out.println(l2);
//        System.out.println(Arrays.toString(arr));
    }

    /**
     * 希尔排序：交换式
     * @param arr
     */
    public static void shellSort(int[] arr){
        int temp=0;
        for (int i = arr.length/2; i >0 ; i/=2) {  //控制循环的次数,i为隔多少个比一次
            //进行比较
            for (int j = i; j <arr.length; j++) {
                for (int k = j-i; k >=0 ; k-=i) {
                    if (arr[k]>arr[k+i]){
                        temp=arr[k];
                        arr[k]=arr[k+i];
                        arr[k+i]=temp;
                    }
                }
            }
        }
    }

    /**
     * 移位式希尔排序
     * @param arr
     */
    public static void shellMove(int[] arr){
        int temp=0;
        int index=0;
        for (int i = arr.length/2; i >0 ; i/=2) {  //控制循环的次数,i为隔多少个比一次
            //进行比较
            for (int j = i; j <arr.length; j++) {
                temp=arr[j];
                index=j-i;
                while (index>=0&&temp<arr[index]){
                    arr[index+i]=arr[index];
                    index-=i;
                }
                arr[index+i]=temp;
            }
        }
    }
}
