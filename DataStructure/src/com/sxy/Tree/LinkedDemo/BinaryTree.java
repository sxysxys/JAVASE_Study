package com.sxy.Tree.LinkedDemo;

/**
 * 二叉树
 * 遍历
 */
public class BinaryTree {
    private TreeNode root;

    private TreeNode pre;  //记录每次遍历之前的那个node

    public TreeNode getPre() {
        return pre;
    }

    public void setPre(TreeNode pre) {
        this.pre = pre;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void threadNodes(){
        threadNodes(root);
    }

    /**
     * 中序遍历，将二叉树变成线索二叉树
     * @param treeNode
     */
    public void threadNodes(TreeNode treeNode){
        if (treeNode==null){
            return;
        }
        threadNodes(treeNode.getlTree());
        //处理左节点
        if (treeNode.getlTree()==null){
            treeNode.setlTree(pre);  //pre代表遍历的前一个
            treeNode.setLeftType(1);
        }
        //处理右节点
        if (pre!=null&&pre.getrTree()==null){
            pre.setrTree(treeNode);
            pre.setRightType(1);
        }

        pre=treeNode;

        threadNodes(treeNode.getrTree());

    }

    /**
     * 遍历线索二叉树
     *
     */
    public void threadIterate(){
        TreeNode node = this.root;
        while (node!=null){
            while (node.getlTree()!=null&&node.getLeftType()==0){
                node=node.getlTree();
            }
            System.out.print(node.value+" ");
            while (node.getRightType()==1){
                node=node.getrTree();
                System.out.print(node.value+" ");
            }
            //当出现node的右边是普通连接节点时、
            node=node.getrTree();
        }
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
