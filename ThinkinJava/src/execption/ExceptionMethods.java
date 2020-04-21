package execption;

import java.io.IOException;

/**
 * @Author: shenge
 * @Date: 2020-04-10 15:12
 *
 * 每一级别都能获得更多的信息。
 */
public class ExceptionMethods {
    public static void main(String[] args) {
        try {
            throw new IOException("My Exception");
        } catch(Exception e) {
            System.out.println("Caught Exception");
            System.out.println(
                    "getMessage():" + e.getMessage());
            System.out.println("getLocalizedMessage():" +
                    e.getLocalizedMessage());
            System.out.println("toString():" + e);
            System.out.println("printStackTrace():");
            e.printStackTrace(System.out);
        }
        System.out.println("我也输出了奥");
    }
}