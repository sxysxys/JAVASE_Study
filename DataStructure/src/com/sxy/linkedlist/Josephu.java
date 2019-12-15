package com.sxy.linkedlist;

public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
/*        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();*/
        circleSingleLinkedList.countBoy(10,2,85);
    }
}
//创建一个环形的单向链表
class CircleSingleLinkedList{
    //创建一个first节点，当前没有编号,以后执行都是从这个节点开始遍历。
    private Boy first= null;

    //添加多少个男孩参加游戏
    public void addBoy(int nums){
        if (nums<1){
            System.out.println("输出的数字不正确");
            return;
        }
        //使用for循环创建链表
        Boy curBoy=null;
        for (int i = 1; i <=nums; i++) {
            Boy boy = new Boy(i);
            if (i==1) {
                first = boy;
                first.setNext(first);
                curBoy=first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy=boy;
            }
        }
    }

    //遍历当前环形链表
    public void showBoy(){
        if (first==null){
            System.out.println("没有任何小孩");
            return;
        }
        Boy curBoy=first;  //利用curBoy指针进行遍历
        while (true){
            System.out.printf("小孩的编号%d\n",curBoy.getNo());
            if (curBoy.getNext()==first){
//                System.out.println("遍历完毕");
                break;  //此时curBoy指向最后一个小孩。
            }
            curBoy=curBoy.getNext();
        }
    }

    //根据用户的输入，计算出小孩出圈的顺序。
    /**
     *  在报数前，先让first和helper移动start-1个位置。
     * @param startNum 从第几个小孩开始数
     * @param countNum 数多少下
     * @param nums 有多少个小孩在圈中
     */
    public void countBoy(int startNum,int countNum,int nums){
        //添加小男孩
        addBoy(nums);
        //先进行一个初始判断校验
        if (first==null||nums<1){
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        //让helper指向最后一个节点
        Boy helper=first;
        while (true){
            if (helper.getNext()==first){
                break;  //此时helper指向了最后一个节点
            }
            helper=helper.getNext();
        }
        //将first和helper移动k-1个节点的位置
        for (int i = 0; i < startNum - 1; i++) {
            first=first.getNext();
            helper=helper.getNext();
        }
        //正式开始报数
        while (true){
            if (helper==first){  //此时圈中只剩一个人了
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first=first.getNext();
                helper=helper.getNext();
            }
            System.out.printf("要出圈的小孩编号是%d\n",first.getNo());
            first=first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号是%d\n",first.getNo());
    }
}
//创建一个boy类，表示一个节点。
class Boy{
    private int no;
    private Boy next;
    Boy(int no){
        this.no=no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}