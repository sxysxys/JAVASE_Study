package com.sxy.Tree.LinkedDemo;

public class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode node1 = new TreeNode(1);
        binaryTree.setRoot(node1); //设置二叉树根节点

        TreeNode lTree = new TreeNode(2);
        node1.setlTree(lTree);
        TreeNode rTree = new TreeNode(3);
        node1.setrTree(rTree);

        lTree.setlTree(new TreeNode(4));
        lTree.setrTree(new TreeNode(5));
        rTree.setlTree(new TreeNode(6));
        rTree.setrTree(new TreeNode(7));

        //创建完了二叉树
        System.out.println("前序排列为:");
        binaryTree.frontShow();
        System.out.println();
        System.out.println("中序排列为:");
        binaryTree.midShow();
        System.out.println();
        System.out.println("后序排列为:");
        binaryTree.behindShow();
        System.out.println("前序查找的结果:");
        TreeNode seaNode =binaryTree.frontSearch(2);
        System.out.println(seaNode);
        //删除某个节点
        binaryTree.delete(6);
        binaryTree.frontShow();
        System.out.println();
        binaryTree.midShow();
    }
}
