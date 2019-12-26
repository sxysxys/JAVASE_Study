package com.sxy.Tree.ArrayBinaryTree;

public class TestABTreeDemo {
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5,6,7};
        ABTree abTree = new ABTree(arr);
        abTree.frontShow(0);
    }
}
