package com.sxy.Tree.ArrayBinaryTree;

public class ABTree {
    private int[] data;
    public ABTree(int[] data){
        this.data=data;
    }

    /**
     * 前序遍历
     */
    public void frontShow(int index){
        if (data==null||data.length==0){
            return;
        }
        System.out.print(data[index]+" ");
        if (index*2+1<data.length){
            frontShow(index*2+1);
        }

        if (index*2+2<data.length){
            frontShow(index*2+2);
        }
    }
}
