package com.sxy.sort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
//        int[] arr={9,8,7,0,1,10,4,2,3};
        //创建数组
        int[] arr=new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i]=(int)(Math.random()*8000000);
        }
        long l = System.currentTimeMillis();
        heapSort(arr);
        long l1 = System.currentTimeMillis();
        long l2 = l1 -l;
        System.out.printf("花费了%d秒",l2);
//        System.out.println(Arrays.toString(arr));
    }

    /**
     * 将某个节点及其下面进行堆排序，用递归
     * 递归一般都是先考虑实现一个二叉树，然后再进行递归
     */
    public static void maxHeap(int[] arr,int index,int size){
        int left = 2*index+1;
        int right =2*index+2;
        int max = index;
        if (left<size&&arr[max]<arr[left]){
            max=left;
        }
        if (right<size&&arr[max]<arr[right]){
            max=right;
        }
        //交换
        if (max!=index){
            int temp=arr[index];
            arr[index]=arr[max];
            arr[max]=temp;
            maxHeap(arr,max,size);
        }
    }

    /**
     * 输出一个顺序数组
     */
    public static void heapSort(int[] arr){
        //循环不包含子节点的次数
        for (int i = (arr.length-1)/2; i >=0; i--) {
            maxHeap(arr,i,arr.length);
        }
//        System.out.println(Arrays.toString(arr));
        //此时化成了第一个大顶堆
        for (int i = arr.length-1; i >0 ; i--) {
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            //每次改变只要排一次即可
            maxHeap(arr,0,i);
        }
    }
}
