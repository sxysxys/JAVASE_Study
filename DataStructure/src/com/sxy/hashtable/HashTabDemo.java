package com.sxy.hashtable;

import java.util.Scanner;

/**
 * 使用哈希表添加雇员
 */
public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(8);
        Scanner scanner = new Scanner(System.in);
        String next="";
        while (true){
            System.out.println("add : 添加雇员");
            System.out.println("list : 列出雇员");
            System.out.println("find : 查找雇员");
            System.out.println("exit : 退出");
            next = scanner.next();
            switch (next){
                case "add":
                    System.out.println("请输入id:");
                    int id=scanner.nextInt();
                    System.out.println("请输入name:");
                    String name=scanner.next();
                    hashTab.add(new Emp(id,name));
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入id:");
                    int i=scanner.nextInt();
                    hashTab.findById(i);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
//表示一个雇员
class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

/**
 * 表示雇员链表
 */
class EmpLinkedList{
    //指向第一个Emp
    private Emp head;

    /**
     * 添加雇员时，id从小到大。
     */
    public void add(Emp emp){
        //如果是第一个
        if (head==null){
            head=emp;
            return;
        }
        //如果不是第一个，则添加辅助的指针，帮助定位到链表的最后一个。
        Emp curemp = this.head;
        while (curemp.next!=null){
            curemp=curemp.next;
        }
        curemp.next=emp;
    }

    /**
     * 遍历雇员信息
     */
    public void list(int i){
        if (head==null){  //说明链表为空
            System.out.printf("链表%d为空\n",i);
            return;
        }
        System.out.printf("链表%d信息为:\n",i);
        Emp curemp=head;
        while (curemp!=null){
            System.out.printf("id=%d,name=%s\n",curemp.id,curemp.name);
            curemp=curemp.next;
        }

    }

    /**
     * 返回id对应的雇员,如果查找到就返回emp
     * @param id
     * @return
     */
    public Emp findEmpById(int id){
        if(head==null){
            System.out.printf("%d号链表为空\n",id);
            return null;
        }
        Emp cur=head;
        boolean flag=true;
        while (cur.id!=id){
            cur=cur.next;
            if (cur==null){
                flag=false;
                break;
            }
        }
        if (flag){
            return cur;
        }else {
            return null;
        }
    }

}

/**
 * 创建哈希表
 * 里面用一个数组存放多个链表
 */
class HashTab{
    public EmpLinkedList[] empLinkedLists;
    public int size;  //表示有几条链表

    public HashTab(int size){
        this.size=size;
        empLinkedLists=new EmpLinkedList[size];
        //需要将数组的每一个元素赋值，否则空指针。
        for (int i = 0; i < empLinkedLists.length; i++) {
            empLinkedLists[i]=new EmpLinkedList();
        }
    }

    /**
     * 添加雇员
     * @param emp
     */
    public void add(Emp emp){
        int employNo=emp.id%size;
        empLinkedLists[employNo].add(emp);
    }

    /**
     * 列出所有链表
     */
    public void list(){
        for (int i = 0; i < empLinkedLists.length; i++) {
            empLinkedLists[i].list(i);
        }
    }

    public void findById(int id){
        int i = id % size;
        Emp empById = empLinkedLists[i].findEmpById(id);
        if (empById!=null){
            System.out.printf("在第%d条链表中找到该雇员\n",i);
        }else {
            System.out.println("没有找到该元素");
        }
    }

}
