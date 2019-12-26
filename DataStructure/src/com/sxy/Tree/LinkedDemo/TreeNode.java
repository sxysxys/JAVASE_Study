package com.sxy.Tree.LinkedDemo;

/**
 * 二叉树节点
 */
public class TreeNode {
    //节点的度
    int value;

    //左节点和右节点
    private TreeNode lTree;
    private TreeNode rTree;

    public TreeNode(int value){
        this.value = value;
    }

    public TreeNode getlTree() {
        return lTree;
    }

    public void setlTree(TreeNode lTree) {
        this.lTree = lTree;
    }

    public TreeNode getrTree() {
        return rTree;
    }

    public void setrTree(TreeNode rTree) {
        this.rTree = rTree;
    }

    /**
     * 前序遍历
     */
    public void frontShow() {
        System.out.print(value+" ");
        if (lTree!=null){
            lTree.frontShow();
        }
        if (rTree!=null){
            rTree.frontShow();
        }
    }

    /**
     * 中序遍历
     */
    public void midShow() {
        if (lTree!=null){
            lTree.midShow();
        }
        //此时lTree等于null了，这是当前节点
        System.out.print(value+" ");
        if (rTree!=null){
            rTree.midShow();
        }
    }

    /**
     * 后序排序
     */
    public void behindShow() {
        if (lTree!=null){
            lTree.behindShow();
        }
        if (rTree!=null){
            rTree.behindShow();
        }
        System.out.print(value+" ");
    }

    /**
     * 前序查找
     * @param i
     * @return
     */
    public TreeNode frontSearch(int i) {
        TreeNode treeNode;
        if (i==this.value){
            return this;
        }else {
            if (lTree!=null){
                treeNode = lTree.frontSearch(i);
                if (treeNode!=null){
                    return treeNode;
                }
            }
            if (rTree!=null){
                treeNode = rTree.frontSearch(i);
                if (treeNode!=null){
                    return treeNode;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", lTree=" + lTree +
                ", rTree=" + rTree +
                '}';
    }

    /**
     * 删除节点
     * @param i
     * 返回1代表已经找到
     */
    public boolean delete(int i) {
        TreeNode cur = this;
        if (cur.lTree!=null&&cur.lTree.value==i){
            cur.lTree=null;
            return true;
        }
        if (cur.rTree!=null&&cur.rTree.value==i){
            cur.rTree=null;
            return true;
        }

        if (cur.lTree!=null) {
            if (cur.lTree.delete(i)){
                return true;
            }
        }

        if (cur.rTree != null) {
            if (cur.rTree.delete(i)){
                return true;
            }
        }

        return false;
    }
}
