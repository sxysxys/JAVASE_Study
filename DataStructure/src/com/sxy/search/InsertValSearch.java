package com.sxy.search;

/**
 * 插值查找法。
 */
public class InsertValSearch {
    public static void main(String[] args) {
        //建立1-100的数组
        int[] arr=new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i+1;
        }
//        System.out.println(insertSearch(arr,0,arr.length-1,55));
        System.out.println(binartSearch(arr,0,arr.length,76));
    }

    /**
     * 使用递归方法进行插值查找。
     * @param arr
     * @param left
     * @param right
     * @param val
     * @return
     */
    public static int insertSearch(int[] arr,int left,int right,int val){
        if (left>right||val<arr[0]||val>arr[arr.length-1]){
            return -1;
        }
        int mid=left+(right-left)*(val-arr[left])/(arr[right]-arr[left]);
        if (arr[mid]==val){
            return mid;
        }else if (arr[mid]>val){
            return insertSearch(arr,left,mid-1,val);
        }else {
            return insertSearch(arr,mid+1,right,val);
        }
    }

    /**
     * 传统二分法递归查找
     * @param arr
     * @param left
     * @param right
     * @param val
     * @return
     */
    public static int binartSearch(int[] arr,int left,int right,int val){
        if (left>right||val<arr[0]||val>arr[arr.length-1]){
            return -1;
        }
        int mid=(left+right)/2;
        if (arr[mid]==val){
            return mid;
        }else if (arr[mid]>val){
            return binartSearch(arr,left,mid-1,val);
        }else {
            return binartSearch(arr,mid+1,right,val);
        }
    }
}
