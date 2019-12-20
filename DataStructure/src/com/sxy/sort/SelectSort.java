package com.sxy.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr=new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i]=(int)(Math.random()*800000);
        }
        long l = System.currentTimeMillis();
        selectSort(arr);
        long l1 = System.currentTimeMillis();
        long miao=(l1-l)/1000;
        System.out.printf("排序花费了%d秒\n",miao);
//        System.out.println(Arrays.toString(arr));

    }

    /**
     * 选择排序
     * 依次选中元素放在数组相应的位置
     * @param arr
     */
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex=i;  //数组下标从i开始
            int min=arr[i];  //假设最小值为第一个
            for (int j = i+1; j <arr.length ; j++) {
                if (arr[j]<min){
                    minIndex=j;
                    min=arr[j];
                }
            }
            if (min!=arr[i]){
                arr[minIndex]=arr[i];
                arr[i]=min;
            }
        }
    }
}
