package com.sxy.Tree.BinarySort;

public class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /**
     * 添加节点
     * @param node
     */
    public void add(Node node) {
        if (node==null){
            return;
        }else {
            if (node.value>this.value){
                if (this.right==null){
                    this.right=node;
                }else {
                    this.right.add(node);
                }
            }else {
                if (this.left==null){
                    this.left=node;
                }else {
                    this.left.add(node);
                }
            }
        }
        //添加完节点之后，检查是否平衡

    }

    /**
     * 中序遍历，将二叉树按从小到大的顺序输出。
     */
    public void frontShow() {
        if (left!=null){
            this.left.frontShow();
        }
        System.out.println(this.value);
        if (right!=null){
            this.right.frontShow();
        }
    }

    /**
     * 按中序遍历查找
     * @param value
     * @return
     */
    public Node findIndex(int value) {
        Node node;
        if (left!=null){
            node=this.left.findIndex(value);
            if (node!=null){
                return node;
            }
        }
        if (this.value==value){
            return this;
        }
        if (right!=null){
            node= this.right.findIndex(value);
            if (node!=null){
                return node;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    /**
     * 查找某个节点的父节点
     * @param value
     * @return
     */
    public Node findParent(int value) {
        Node node;
        if ((this.left!=null&&this.left.value==value)||(this.right!=null&&this.right.value==value)){
            return this;
        }else {
            if (this.left!=null&&this.value>value){
                node = this.left.findParent(value);
                if (node!=null){
                    return node;
                }
            }else if (this.right!=null&&this.value<value){
                node= this.right.findParent(value);
                if (node!=null){
                    return node;
                }
            }
        }
        return null;
    }

//    public int height(){
//    }

}
