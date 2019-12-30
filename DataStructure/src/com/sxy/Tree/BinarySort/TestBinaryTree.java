package com.sxy.Tree.BinarySort;

public class TestBinaryTree {
    public static void main(String[] args) {
        int[] arr = new int[]{7,3,10,12,5,1,9};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i : arr) {
            binarySortTree.add(new Node(i));
        }
        binarySortTree.frontShow();
        int value=3;
        Node findResult=binarySortTree.findIndex(value);
        System.out.println(findResult);
//        binarySortTree.deleteNode(value);
        Node parent = binarySortTree.findParent(9);
        System.out.println(parent);
        binarySortTree.deleteNode(7);
        binarySortTree.frontShow();
    }
}
