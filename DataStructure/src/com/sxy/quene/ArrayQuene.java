package com.sxy.quene;

public class ArrayQuene {
    //定义一个队列
        private int maxsize;
        private int front;
        private int rear;
        private int[] arr;

        //创建队列的构造器
        public ArrayQuene(int maxsize){
            this.maxsize=maxsize;
            this.arr=new int[maxsize];
            this.front=-1;  //指向队列头部的前一个位置
            this.rear=-1;  //指向队列的尾部，即就是队列最后的一个数据
        }

        //判断队列是否满
        public boolean isFull(){
            return (rear==maxsize-1);
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
            arr[++rear]=n;  //先加rear，再往里面存数据。
        }
        //获取队列的数据
        public int getQuene(){
            if (isEmpty()){
                throw new RuntimeException("队列为空，不能取数据");
            }
            return arr[++front];
        }
        //显示队列所有的数据
        public void showQuene(){
            if(isEmpty()){
                System.out.println("队列为空，没有数据");
                return;
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("arr[%d]=%d\n",i,arr[i]);
            }
        }
        //显示队列的头数据
        public int headQuene(){
            if (isEmpty()){
                throw new RuntimeException("队列为空，没有数据");
            }
            return arr[front+1];
        }
}
