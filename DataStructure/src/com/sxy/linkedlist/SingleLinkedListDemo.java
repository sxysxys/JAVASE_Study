package com.sxy.linkedlist;

/**
 * 单链表
 * 需求1：添加人物进链表，按顺序添加
 * 需求2：按照人物的排名添加进链表
 * 此时需要找到相应的节点，然后在相应的节点.next指向temp,将temp.next指向相应节点后的节点
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //创建链表
        SingleLinkedlist singleLinkedlist = new SingleLinkedlist();
        singleLinkedlist.addByOrder(new HeroNode(1,"小张","石乐志"));
        singleLinkedlist.addByOrder(new HeroNode(4,"小郭","母鸡"));
        singleLinkedlist.addByOrder(new HeroNode(4,"小李","what"));
        singleLinkedlist.addByOrder(new HeroNode(2,"小马","徐晃"));
        singleLinkedlist.addByOrder(new HeroNode(3,"小吴","啥情况"));
        singleLinkedlist.edit(new HeroNode(3,"sxy","修改后的"));
        singleLinkedlist.del(1);

        singleLinkedlist.list();
    }
}

class SingleLinkedlist{
    private HeroNode head=new HeroNode(0,"","");//头节点不存放数据

    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    //遍历找到最后的节点
    //将这个节点的next指向新的节点
    public void add(HeroNode heroNode){
        HeroNode temp=head;
        //找到最后一个temp
        while (true){
            if (temp.next==null){
                break;
            }
            temp=temp.next;
        }
        //此时的temp即为最后的值
        temp.next=heroNode;
    }

    public void addByOrder(HeroNode heroNode){
        //找添加位置的前一个节点
        HeroNode temp=head;
        boolean flag=false;//标志这个添加的节点是否存在。
        while (true){
            if (temp.next==null||temp.next.no>heroNode.no){
                break;
            }
            if (temp.next.no==heroNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            System.out.printf("所添加的编号%d已经存在了\n",heroNode.no);
        }else {
            heroNode.next=temp.next;
            temp.next=heroNode;
        }

    }

    //修改链表
    public void edit(HeroNode heroNode){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        boolean flag=false;
        HeroNode temp=head.next;
        while (true){
            if (temp==null){
                break;
            }
            if (heroNode.no==temp.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.name=heroNode.name;
            temp.nikeName=heroNode.nikeName;
        }else {
            System.out.printf("没有找到编号为%d的人\n",heroNode.no);
        }
    }

    //删除链表
    public void del(int no){
        if (head.next==null){
            System.out.println("链表为空！!");
        }
        boolean flag=false;
        HeroNode temp=head;
        while(true){
            if (temp.next==null){
                break;
            }
            if (temp.next.no==no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.next=temp.next.next;
        }else {
            System.out.printf("并没有编号为%d的元素",no);
        }
    }
    //显示链表
    public void list(){
        //判断链表是否为空
        if (head.next==null){
            System.out.println("链表为空！！");
            return;
        }
        //因为头节点不能动，需要一个辅助节点进行遍历
        HeroNode temp = head.next;
        while(true){
            if (temp==null){
                break;
            }
            System.out.println(temp);
            temp=temp.next;
        }
    }
}
class HeroNode{
    public int no;
    public String name;
    public String nikeName;
    public HeroNode next;

    public HeroNode(int no, String name, String nikeName) {
        this.no = no;
        this.name = name;
        this.nikeName = nikeName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nikeName='" + nikeName + '\'' +
                '}';
    }
}
