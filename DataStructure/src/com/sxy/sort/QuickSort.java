package com.sxy.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
//        int[] arr={-9,78,0,23,-567,70};
        //创建数组
        int[] arr=new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i]=(int)(Math.random()*8000000);
        }
        long l = System.currentTimeMillis();
        quickSort(arr,0,arr.length-1);
        long l1 = System.currentTimeMillis();
        long l2 = (l1 -l)/1000;
        System.out.printf("花费了%d秒",l2);
//        System.out.println(Arrays.toString(arr));
    }

    /**
     * 取最左边的数为基准。
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr,int left,int right) {
        if (left < right) {
            int stard = arr[left];
            int zuo = left;
            int you = right;
            while (zuo < you) {
                while (zuo < you && arr[you] > stard) {
                    you--;
                }
                if (zuo<you)
                    arr[zuo] = arr[you];

                while (zuo < you && arr[zuo] < stard) {
                    zuo++;
                }
                if (zuo<you)
                    arr[you] = arr[zuo];
            }
            arr[zuo] = stard;
            quickSort(arr, left, zuo-1 );
            quickSort(arr, zuo + 1, right);
        }
    }
}
