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
     *
     * @param node
     */
    public void add(Node node) {
        if (node == null) {
            return;
        } else {
            if (node.value > this.value) {
                if (this.right == null) {
                    this.right = node;
                } else {
                    this.right.add(node);
                }
            } else {
                if (this.left == null) {
                    this.left = node;
                } else {
                    this.left.add(node);
                }
            }
        }
        //添加完节点之后，进行左旋转。
        if (rightHeight()-leftHeight()>1){
            if (right!=null&&right.rightHeight()>right.leftHeight()){  //此时进行左旋转
                leftRotate();
            }
            if (right!=null&&right.rightHeight()<right.leftHeight()){  //此时进行左旋转
                rightDouble();
            }
        }
        if (leftHeight()-rightHeight()>1){
            if (left!=null&&left.leftHeight()>left.rightHeight()){
                rightRotate();
            }
            if (left!=null&&left.leftHeight()<left.rightHeight()){
                leftDouble();
            }
        }
    }

    public void rightDouble() {
        right.rightRotate();
        leftRotate();
    }

    /**
     * 中序遍历，将二叉树按从小到大的顺序输出。
     */
    public void frontShow() {
        if (left != null) {
            this.left.frontShow();
        }
        System.out.println(this.value);
        if (right != null) {
            this.right.frontShow();
        }
    }

    /**
     * 按中序遍历查找
     *
     * @param value
     * @return
     */
    public Node findIndex(int value) {
        Node node;
        if (left != null) {
            node = this.left.findIndex(value);
            if (node != null) {
                return node;
            }
        }
        if (this.value == value) {
            return this;
        }
        if (right != null) {
            node = this.right.findIndex(value);
            if (node != null) {
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
     *
     * @param value
     * @return
     */
    public Node findParent(int value) {
        Node node;
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (this.left != null && this.value > value) {
                node = this.left.findParent(value);
                if (node != null) {
                    return node;
                }
            } else if (this.right != null && this.value < value) {
                node = this.right.findParent(value);
                if (node != null) {
                    return node;
                }
            }
        }
        return null;
    }

    /**
     * 返回节点高度
     *
     * @return
     */
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    /**
     * 返回左子树的高度
     * @return
     */
    public int leftHeight(){
        if (left==null){
            return 0;
        }else {
            return left.height();
        }
    }

    /**
     * 返回右子树的高度
     * @return
     */
    public int rightHeight(){
        if (right==null){
            return 0;
        }else {
            return right.height();
        }
    }

    /**
     * 左旋转，当右边高度大于左边高度的时候。
     */
    public void leftRotate() {
        //创建新的节点
        Node node = new Node(value);
        node.left = left;
        node.right = right.left;
        //将当前节点变成右子树节点
        value = right.value;
        left = node;
        right = right.right;
    }

    /**
     * 右旋转，当左边高度大于右边高度两个单位以上的时候
     */
    public void rightRotate() {
        Node node = new Node(value);
        node.right = right;
        node.left = left.right;
        value = left.value;
        right = node;
        left = left.left;
    }

    /**
     * 左侧双向旋转
     */
    public void leftDouble(){
        left.leftRotate();
        rightRotate();
    }
}
