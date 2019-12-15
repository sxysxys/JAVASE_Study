package com.sxy.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("双向链表的测试");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(new DoubleNode(1,"小张","石乐志"));
        doubleLinkedList.add(new DoubleNode(4,"小郭","母鸡"));
        doubleLinkedList.add(new DoubleNode(2,"小马","徐晃"));
        doubleLinkedList.add(new DoubleNode(3,"小吴","啥情况"));

        doubleLinkedList.edit(new DoubleNode(4,"小狗","啥子"));

        doubleLinkedList.del(2);
        doubleLinkedList.list();
    }
}
class DoubleLinkedList{
    private DoubleNode head=new DoubleNode(0,"","");

    public DoubleNode getDoubleNode() {
        return head;
    }

    //显示链表
    public void list(){
        //判断链表是否为空
        if (head.next==null){
            System.out.println("链表为空！！");
            return;
        }
        //因为头节点不能动，需要一个辅助节点进行遍历
        DoubleNode temp = head.next;
        while(true){
            if (temp==null){
                break;
            }
            System.out.println(temp);
            temp=temp.next;
        }
    }
    //增加节点
    public void add(DoubleNode doubleNode){
        DoubleNode temp=head;
        //找到最后一个temp
        while (true){
            if (temp.next==null){
                break;
            }
            temp=temp.next;
        }
        //此时的temp即为最后的值
        temp.next=doubleNode;
        doubleNode.pre=temp;
    }

    //修改链表
    public void edit(DoubleNode doubleNode){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        boolean flag=false;
        DoubleNode temp=head.next;
        while (true){
            if (temp==null){
                break;
            }
            if (doubleNode.no==temp.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.name=doubleNode.name;
            temp.nikeName=doubleNode.nikeName;
        }else {
            System.out.printf("没有找到编号为%d的人\n",doubleNode.no);
        }
    }

    /**
     * 直接找到删除的节点，删除即可。
     * @param no
     */
    public void del(int no){
        if (head.next==null){
            System.out.println("链表为空！!");
        }
        boolean flag=false;
        DoubleNode temp=head.next;
        while(true){
            if (temp==null){
                break;
            }
            if (temp.no==no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.pre.next=temp.next;
            //如果删除的是最后一个元素,不加if会出现空指针异常。
            if (temp.next!=null){
                temp.next.pre=temp.pre;
            }
        }else {
            System.out.printf("并没有编号为%d的元素",no);
        }
    }


}
//双向链表节点
class DoubleNode{
    public int no;
    public String name;
    public String nikeName;
    public DoubleNode next;
    public DoubleNode pre;

    public DoubleNode(int no, String name, String nikeName) {
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
