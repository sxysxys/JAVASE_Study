package string.formatter;

/**
 * @Author: shenge
 * @Date: 2020-04-13 09:37
 *
 * 通用Formatter格式化方法。
 * 可以输出到io流，appendable等中.
 */
import java.io.*;
import java.util.*;

public class Turtle {
    private String name;
    private Formatter f;
    public Turtle(String name, Formatter f) {
        this.name = name;
        this.f = f;
    }
    public void move(int x, int y) {
        f.format("%s The Turtle is at (%d,%d)%n",
                name, x, y);
    }
    public static void main(String[] args) {
        PrintStream outAlias = System.out;
        Turtle tommy = new Turtle("Tommy",
                new Formatter(System.out));
        Turtle terry = new Turtle("Terry",
                new Formatter(outAlias));
        tommy.move(0,0);
        terry.move(4,8);
        tommy.move(3,4);
        terry.move(2,5);
        tommy.move(3,3);
        terry.move(3,3);
        System.out.println("--------------");
        int x = 5;
        double y = 5.332542;
        // The old way:
        System.out.println("Row 1: [" + x + " " + y + "]");
        // The new way:
        System.out.format("Row 2: [%d %f]%n", x, y);
        // or
        System.out.printf("Row 3: [%d %f]%n", x, y);
    }
}