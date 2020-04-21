package tools;

import java.util.Arrays;

/**
 * @Author: shenge
 * @Date: 2020-04-18 15:00
 *
 * 显示数组的tools
 */
public interface ArrayShow {
    static void show(Object[] a) {
        System.out.println(Arrays.toString(a));
    }
    static void show(boolean[] a) {
        System.out.println(Arrays.toString(a));
    }
    static void show(byte[] a) {
        System.out.println(Arrays.toString(a));
    }
    static void show(char[] a) {
        System.out.println(Arrays.toString(a));
    }
    static void show(short[] a) {
        System.out.println(Arrays.toString(a));
    }
    static void show(int[] a) {
        System.out.println(Arrays.toString(a));
    }
    static void show(long[] a) {
        System.out.println(Arrays.toString(a));
    }
    static void show(float[] a) {
        System.out.println(Arrays.toString(a));
    }
    static void show(double[] a) {
        System.out.println(Arrays.toString(a));
    }
    // Start with a description:
    static void show(String info, Object[] a) {
        System.out.print(info + ": ");
        show(a);
    }
    static void show(String info, boolean[] a) {
        System.out.print(info + ": ");
        show(a);
    }
    static void show(String info, byte[] a) {
        System.out.print(info + ": ");
        show(a);
    }
    static void show(String info, char[] a) {
        System.out.print(info + ": ");
        show(a);
    }
    static void show(String info, short[] a) {
        System.out.print(info + ": ");
        show(a);
    }
    static void show(String info, int[] a) {
        System.out.print(info + ": ");
        show(a);
    }
    static void show(String info, long[] a) {
        System.out.print(info + ": ");
        show(a);
    }
    static void show(String info, float[] a) {
        System.out.print(info + ": ");
        show(a);
    }
    static void show(String info, double[] a) {
        System.out.print(info + ": ");
        show(a);
    }
}