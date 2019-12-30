package com.sxy.Tree.BinarySort;

/**
 * 二叉排序树
 */
public class BinarySortTree {
    public Node root;

    public void add(Node node){
        if (root==null){
            root=node;
        }else {
            root.add(node);
        }
    }

    public void frontShow(){
        if (root==null){
            return;
        }else {
            root.frontShow();
        }
    }

    public Node findIndex(int value) {
        return root.findIndex(value);
    }

    /**
     * 删除叶子节点
     * @param value
     */
    public void deleteNode(int value) {
        if (root==null){
            return;
        }else {
            //1.找到这个节点
            //2.找到父节点
            Node index = findIndex(value);
            if (index==null){  //如果没有这个节点
                return;
            }
            Node parent=findParent(value);
            if (index.left==null&&index.right==null){
                if (index.value>parent.value){
                    parent.right=null;
                }else {
                    parent.left=null;
                }
            }else if (index.left!=null&&index.right!=null){    //一个节点挂了两个子节点
            //删除左子树中最大的节点或右子树中最小的节点，获取到该节点的值赋给要删除的节点
                int min=deleteMin(index.right);
                index.value=min;
            }else {  //一个节点只挂了一个节点
                if (index.left!=null){  //挂了左子节点
                    if (index.value>parent.value){
                        parent.right=index.left;
                    }else {
                        parent.left=index.left;
                    }
                }else {  //挂了右子节点
                    if (index.value>parent.value){
                        parent.right=index.right;
                    }else {
                        parent.left=index.right;
                    }
                }
            }
        }
    }

    /**
     * 删除这个节点的最小节点，将这个节点的值返回
     * @param node
     * @return
     */
    public int deleteMin(Node node) {
        if (root==null){
            return 0;
        }else {
            while (node.left!=null){
                node=node.left;
            }
            deleteNode(node.value);
            return node.value;
        }
    }


    public Node findParent(int value) {
        if (root==null){
            return null;
        }else {
            return root.findParent(value);
        }
    }
}
