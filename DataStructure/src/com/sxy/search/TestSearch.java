package com.sxy.search;

/**
 * 二分法查找
 *
 */
public class TestSearch {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5,6,7,8,9};
        int check=6;
        int begin=0;
        int end=arr.length-1;
        int middle=(begin+end)/2;
        int index=-1;  //目标元素的索引
        while (true){
            if (begin>end){
                break;
            }
            if (arr[middle]==check){
                index=middle;
                break;
            }else if (arr[middle]>check){
                end=middle-1;
            }else {
                begin=middle+1;
            }
            middle=(begin+end)/2;
        }
        System.out.printf("目标元素在%d位置上",index);
    }
}
