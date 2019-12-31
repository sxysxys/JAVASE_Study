package com.sxy.Tree.BinarySort;

public class AvlTreeDemo {
    public static void main(String[] args) {
        int[] arr={4,3,6,5,7,8}; //测试左旋转数组
        int[] arrYou={10,12,8,9,7,6}; //测试右旋转数组
        int[] arrzuoDou={10,11,7,6,8,9}; //测试左侧双向旋转数组
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        //中序遍历
        binarySortTree.frontShow();
        System.out.print("在进行平衡处理之后");
        System.out.println("左子树高度为:"+binarySortTree.root.left.height());
        System.out.print("在进行平衡处理之后");
        System.out.println("右子树高度为:"+binarySortTree.root.right.height());

        BinarySortTree binarySortTree1 = new BinarySortTree();
        for (int i = 0; i < arrYou.length; i++) {
            binarySortTree1.add(new Node(arrYou[i]));
        }
        System.out.print("在进行平衡处理之后");
        System.out.println("左子树高度为:"+binarySortTree1.root.left.height());
        System.out.print("在进行平衡处理之后");
        System.out.println("右子树高度为:"+binarySortTree1.root.right.height());

        BinarySortTree binarySortTree2 = new BinarySortTree();
        for (int i = 0; i < arrzuoDou.length; i++) {
            binarySortTree2.add(new Node(arrzuoDou[i]));
        }
        System.out.print("在进行平衡处理之后");
        System.out.println("左子树高度为:"+binarySortTree2.root.left.height());
        System.out.print("在进行平衡处理之后");
        System.out.println("右子树高度为:"+binarySortTree2.root.right.height());
    }

}
