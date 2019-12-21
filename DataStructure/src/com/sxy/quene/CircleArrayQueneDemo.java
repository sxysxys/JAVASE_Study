package com.sxy.quene;

import java.util.Scanner;

/**
 * 需求：数组模拟一个循环队列
 * 实现：永远在环形的后面空一格，从而避免相等时候的误判断。
 * front指向环形数组的第一个元素
 * rear指向最后一个元素的空一位
 */
public class CircleArrayQueneDemo {
    public static void main(String[] args) {
        CircleArray circleArray = new CircleArray(5);
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
                    circleArray.showQuene();
                    break;
                case 'a':
                    System.out.println("输出一个数：");
                    int i = scanner.nextInt();
                    circleArray.addQuene(i);
                    break;
                case 'g':
                    try {
                        int quene = circleArray.getQuene();
                        System.out.printf("取出的数据是:%d\n",quene);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        int i1 = circleArray.headQuene();
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

