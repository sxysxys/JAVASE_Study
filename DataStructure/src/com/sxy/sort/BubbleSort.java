package com.sxy.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 冒泡排序及其优化
 */
public class BubbleSort {
    public static void main(String[] args) {
        //创建数组
        int[] arr=new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i]=(int)(Math.random()*8000000);
        }
//        System.out.println(Arrays.toString(arr));
        //进行排序时间计算
/*        Date date1=new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("排序前的时间是"+simpleDateFormat.format(date1));
        Bubble(arr);
        Date date2=new Date();
        System.out.println("排序后的时间是"+simpleDateFormat.format(date2));*/
        long l = System.currentTimeMillis();
        Bubble(arr);
        long l1 = System.currentTimeMillis();
        long miao=(l1-l)/1000;
        System.out.printf("排序时间是%d秒",miao);

    }

    /**
     * 优化后的冒泡排序
     * @param arr
     */
    public static void Bubble(int[] arr){
        int temp=0;
        boolean flag=false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i-1; j++) {
                if (arr[j]>arr[j+1]){
                    flag=true;
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            if (!flag){
                break;
            }
            flag=false;
        }
    }
}
