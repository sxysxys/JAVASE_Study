package com.sxy.sort;

import com.sxy.quene.ArrayQuene;
import com.sxy.quene.CircleArray;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {
    public static void main(String[] args) {
//        int[] arr ={1,6,7,456,4,5,556,76,8,123};
        //创建数组
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        long l = System.currentTimeMillis();
        radixSort(arr);
        long l1 = System.currentTimeMillis();
        System.out.println((l1 - l) + "秒");
//        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        //先将最大的数的位数取出
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int length = (max + "").length();
//        int temp[][] = new int[10][arr.length];  //创建临时数组进行临时记录
        CircleArray[] temp=new CircleArray[10];
        for (int i = 0; i < 10; i++) {
            temp[i]=new CircleArray(arr.length);
        }
//        int[] counts = new int[10];  //用于对角标的记录，记录每一个余数对应了几个元素
        for (int i = 0, n = 1; i < length; i++, n *= 10) {  //有几位就进行几次循环
            for (int j = 0; j < arr.length; j++) {  //对每一个元素进行遍历
                int yu = arr[j] / n % 10;
//                temp[yu][counts[yu]] = arr[j];
                temp[yu].addQuene(arr[j]);
//                counts[yu]++;
            }
            //把数字取出来,从头到尾依次取出
            int index = 0;
            for (int j = 0; j < temp.length; j++) {
                while (!temp[j].isEmpty()){
                    arr[index++]=temp[j].getQuene();
                }
            }
        }
    }
}
