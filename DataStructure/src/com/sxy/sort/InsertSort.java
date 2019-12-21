package com.sxy.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        //创建数组
        int[] arr=new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i]=(int)(Math.random()*8000000);
        }
//        int[] arr={45,56,23,12,456,4,565,9};
        long l = System.currentTimeMillis();
        insertSort(arr);
        long l1 = System.currentTimeMillis();
        long l2 = l1 -l;
        System.out.printf("花费了%d毫秒",l2);
//        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序
     * @param arr
     */
    public static void insertSort(int[] arr){
        for (int i = 1; i <arr.length ; i++) {
            int insertVal=arr[i];
            int insertIndex=i-1;
            while (insertIndex>=0&&insertVal<arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex+1!=i)
            arr[insertIndex+1]=insertVal;
        }
    }
}
