package com.sxy.Tree.HuffmanTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class HuffmanDemo {
    public static void main(String[] args) {
        int[] arr=new int[]{3,56,2,76,29,41};
        creatHuffman(arr);
    }

    /**
     * 将arr变成赫夫曼树
     * @param arr
     */
    public static void creatHuffman(int[] arr) {
        //用list集合代表赫夫曼树
        ArrayList<Node> nodes = new ArrayList<>();
        for (int val : arr) {
            nodes.add(new Node(val));
        }
        while (nodes.size()>1){
            Collections.sort(nodes);//将nodes的val进行从小到大排序
            System.out.println(nodes);
            Node left=nodes.get(0);
            Node right=nodes.get(1);
            Node center=new Node(left.getValue()+right.getValue());
            center.setLeft(left);
            center.setRight(right);
            try {
                nodes.remove(1);
                nodes.remove(0);
            }catch (ArrayIndexOutOfBoundsException e){
                throw new RuntimeException("数组越界");
            }
            nodes.add(center);
        }
        System.out.println(nodes);
    }
}
