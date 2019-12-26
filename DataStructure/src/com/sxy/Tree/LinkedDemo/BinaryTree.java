package com.sxy.Tree.LinkedDemo;

/**
 * 二叉树
 * 遍历
 */
public class BinaryTree {
    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    /**
     * 前序遍历
     */
    public void frontShow(){
        root.frontShow();
    }

    /**
     * 中序遍历
     */
    public void midShow(){
        root.midShow();
    }

    public void behindShow(){
        root.behindShow();
    }


    public TreeNode frontSearch(int i) {
        return root.frontSearch(i);
    }

    /**
     * 删除某个节点
     * @param i
     */
    public void delete(int i) {
        if (root.value==i){
            root=null;
        }else {
            root.delete(i);
        }
    }
}
