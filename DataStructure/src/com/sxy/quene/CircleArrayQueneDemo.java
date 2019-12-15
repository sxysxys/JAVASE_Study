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

class CircleArray{
    private int maxsize;
    private int front;
    private int rear;
    private int[] arr;

    //创建队列的构造器
    CircleArray(int maxsize){
        this.maxsize=maxsize;
        this.arr=new int[maxsize];
        this.front=0;  //指向队列头部的前一个位置
        this.rear=0;  //指向队列的尾部，即就是队列最后的一个数据
    }

    //判断队列是否满
    public boolean isFull(){
        return (rear+1)%maxsize==front;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return (rear==front);
    }
    //添加数据到队列
    public void addQuene(int n){
        if (isFull()){
            System.out.println("队列已满，不能添加数据！！");
            return;
        }
        arr[rear]=n;
        rear=(rear+1)%maxsize;
    }
    //获取队列的数据
    public int getQuene(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，不能取数据");
        }
        int val= arr[front];
        front=(front+1)%5;
        return val;
    }
    //显示队列所有的数据
    public void showQuene(){
        if(isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }
        //从front开始遍历,rear结束
        for (int i = front; i < front+(rear-front+maxsize)%maxsize;i++) {
            System.out.printf("arr[%d]=%d\n",i%maxsize,arr[i%maxsize]);
        }
    }
    //显示队列的头数据
    public int headQuene(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front];
    }
}