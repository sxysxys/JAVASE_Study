package string.scanner;

import java.util.Scanner;

/**
 * @Author: shenge
 * @Date: 2020-04-13 17:16
 */
public class ScannerDelimiter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("12, 42, 78, 99, 42");
        scanner.useDelimiter(",\\s*");    //以什么东西进行分割元素。
        while (scanner.hasNextInt())   //取下一个这个类型的元素。
            System.out.println(scanner.nextInt());
    }
}