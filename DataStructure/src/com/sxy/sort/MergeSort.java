package com.sxy.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
//        int[] arr ={1,6,7,4,5,76,8};
        //创建数组
        int[] arr=new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i]=(int)(Math.random()*8000000);
        }
        long l = System.currentTimeMillis();
        mergeSort(arr,0,arr.length-1);
        long l1 = System.currentTimeMillis();
        System.out.println((l1-l)+"秒");
//        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并排序，将两个有序的数组进行排序
     * @param arr
     * @param left
     * @param middle  从哪个数开始分隔。
     * @param right
     */
    public static void merge(int[] arr, int left, int middle, int right) {
        int[] temp = new int[right - left + 1];  //temp用于存放临时数组
        int i = left;
        int j = middle + 1;  //分别用于记录左右的起始指针
        int index = 0;  //记录临时数组的索引
        while (i <= middle && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[index] = arr[i];
                i++;
            } else {
                temp[index] = arr[j];
                j++;
            }
            index++;
        }
        while (j <= right) {
            temp[index] = arr[j];
            index++;
            j++;
        }
        while (i <= middle) {
            temp[index] = arr[i];
            index++;
            i++;
        }
        //将temp存入arr
        for (int k = 0; k < temp.length; k++) {
            arr[k + left] = temp[k];
        }
    }

    /**
     * 归并操作。
     * @param arr
     * @param low
     * @param high
     */
    public static void mergeSort(int[] arr, int low, int high) {
        int middle = (high + low) / 2;
        if (low < high) {
            mergeSort(arr, low, middle);
            mergeSort(arr, middle + 1, high);
            merge(arr,low,middle,high);
        }
    }
}
