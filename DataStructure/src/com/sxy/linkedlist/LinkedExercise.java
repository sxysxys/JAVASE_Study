package com.sxy.linkedlist;

import java.util.Stack;

/**
 * 单链表的练习
 * 1.返回链表元素个数
 * 2.查找单链表倒数第k个节点
 */
public class LinkedExercise {
    public static void main(String[] args) {
        LinkedExercise link = new LinkedExercise();
        SingleLinkedlist singleLinkedlist = new SingleLinkedlist();
        singleLinkedlist.addByOrder(new HeroNode(1,"小张","石乐志"));
        singleLinkedlist.addByOrder(new HeroNode(4,"小郭","母鸡"));
        singleLinkedlist.addByOrder(new HeroNode(4,"小李","what"));
        singleLinkedlist.addByOrder(new HeroNode(2,"小马","徐晃"));
        singleLinkedlist.addByOrder(new HeroNode(3,"小吴","啥情况"));
/*        System.out.println(linkedExercise.getLength(singleLinkedlist.getHead()));
        System.out.println(linkedExercise.getKDesc(singleLinkedlist.getHead(),3));*/
/*        link.reverseLinkedList(singleLinkedlist.getHead());
        singleLinkedlist.list();*/
        link.reversePrint(singleLinkedlist.getHead());
    }

    /**
     *送入一个头节点，得到该链表中元素的个数
     * @param head
     * @return
     */
    public int getLength(HeroNode head){
        if (head.next==null){
            System.out.println("链表为空");
            return 0;
        }
        HeroNode temp=head.next;
        int count=0;
        while(true){
            if (temp==null){
                return count;
            }
            count++;
            temp=temp.next;
        }
    }

    /**
     * 查出倒数第k的元素
     * @param head
     * @param index
     * @return
     */
    public HeroNode getKDesc(HeroNode head,int index){
        LinkedExercise linkedExercise = new LinkedExercise();
        int length = linkedExercise.getLength(head);
        int count=length-index+1;
        if (count<=0){
            throw new RuntimeException("索引错误");
        }
        int num=1;
        if (head.next==null){
            System.out.println("查找链表为空！");
            return null;
        }
            HeroNode temp=head.next;
        while(num!=count){
            temp=temp.next;
            num++;
        }
        return temp;
    }

    /**
     * 将一个链表的元素反转
     * 做法：
     * 1.创建一个链表头。
     * 2.将原来的链表遍历一遍，每遍历一个就将链表中的元素添加到创建的链表头中。
     * 3.将参数的链表头的head.next=reverse.next即可
     *
     * 即每摘下来一个就插进最前面去
     * @param head
     */
    public void reverseLinkedList(HeroNode head){
        HeroNode reverseHead=new HeroNode(0,"","");
        if (head.next==null){
            System.out.println("链表为空，无法反转");
            return;
        }
        HeroNode temp=head.next;
        HeroNode next=null;
        while (temp!=null) {
            next=temp.next;
            temp.next=reverseHead.next;  //将目前在遍历的temp的next指针指向它前一个元素，这个元素之前用reversehead.next记录了。
            reverseHead.next=temp;  //每遍历一个就将head指针指向它
            temp=next;
        }
        head.next=reverseHead.next;
    }

    /**
     * 在不改变的数据结构的前提下将链表反转。
     * @param head
     */
    public void reversePrint(HeroNode head){
        if (head.next==null){
            return;
        }
        //创建一个栈数据结构。
        Stack<HeroNode> stack=new Stack<>();
        HeroNode cur=head.next;
        while (cur!=null){
            stack.push(cur);
            cur=cur.next;
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }

}
