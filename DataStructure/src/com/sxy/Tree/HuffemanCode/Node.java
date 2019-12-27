package com.sxy.Tree.HuffemanCode;

public class Node implements Comparable <Node>{
    Byte data;  //存储字符
    int weight;  //权值
    Node left;
    Node right;
    public Node(Byte data,int val){
        this.weight=val;
        this.data=data;
    }

    Node(int val){
        this.weight=val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return o.weight-this.weight;
    }
}
