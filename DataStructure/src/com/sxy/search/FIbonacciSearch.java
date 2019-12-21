package com.sxy.search;

import java.util.Arrays;

/**
 * 斐波那契查找
 */
public class FIbonacciSearch {
    public static int maxsize=20;
    public static void main(String[] args) {
        int[] arr={1,8,10,89,1000,1234};
        System.out.println(fibSearch(arr,1234));
    }

    /**
     * 创建一个斐波那契数列
     * @return
     */
    public static int[] fib(){
        int[] f = new int[maxsize];
        f[0]=1;
        f[1]=1;
        //得到斐波那契数列
        for (int i = 2; i <f.length ; i++) {
            f[i]=f[i-1]+f[i-2];
        }
        return f;
    }

    /**
     * 进行斐波那契查找
     * @param a
     * @param key
     * @return
     */
    public static int fibSearch(int[] a,int key){
        int low=0;
        int high=a.length-1;
        int[] fib = fib();
        int k=0;
        while (high>fib[k]-1){
            k++;
        }
        //此时fib[k]的值很可能大于a数组的长度
        int[] ints = Arrays.copyOf(a, fib[k]); //ints为斐波那契扩充后的数组,找到一个最接近arr长度又大于arr长度的值
        //此时有fib[k]=fib[k-1]+fib[k-2] --->  fib[k]-1=fib[k-1]-1+fib[k-2]-1+1
        for (int i = high+1; i < ints.length; i++) {
            ints[i]=a[high];
        }
        int mid=0;
        while (low<=high){
            mid=low+fib[k-1]-1;
            if(ints[mid]>key){
                high=mid-1;
                k--;
            }else if (ints[mid]<key){
                low=mid+1;
                k-=2;
            }else {  //此时找到了
                if (mid<=high){  //在a数组内部找到
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }
}
