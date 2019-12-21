package com.sxy.quene;

import java.util.Scanner;

/**
 * 数组模拟队列Demo
 * 存在的问题：
 * 数组使用一次就不能用了，没有达到复用的效果。
 * 需要对这个数组使用算法，改成一个环形的队列。
 */
public class ArrayQueneDemo {
    public static void main(String[] args) {
        ArrayQuene arrayQuene = new ArrayQuene(3);
        char key=' ';
        Scanner scanner = new Scanner(System.in);  //其实就是与in所关联起来了。每一次执行scanner方法的时候，都会让用户输入值然后读取用户输入的值。
        boolean loop=true;
        while (loop){
            System.out.println("s:显示队列");
            System.out.println("e:退出程序");
            System.out.println("a:添加数据");
            System.out.println("g:取出数据");
            System.out.println("h:查看队列头数据");
            key=scanner.next().charAt(0);
            switch (key){
                case 's':
                    arrayQuene.showQuene();
                    break;
                case 'a':
                    System.out.println("输出一个数：");
                    int i = scanner.nextInt();
                    arrayQuene.addQuene(i);
                    break;
                case 'g':
                    try {
                        int quene = arrayQuene.getQuene();
                        System.out.printf("取出的数据是:%d\n",quene);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        int i1 = arrayQuene.headQuene();
                        System.out.printf("队列头的数据是：%d\n",i1);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
                default:break;
            }
        }
        System.out.println("程序退出");
    }
}

