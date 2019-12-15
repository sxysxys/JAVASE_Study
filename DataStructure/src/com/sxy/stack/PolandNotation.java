package com.sxy.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 需求：逆波兰表达式的计算
 */
public class PolandNotation {
    public static void main(String[] args) {
        //先定义逆波兰表达式(3+4)*5-6  ==>  3 4 + 5 * 6 -
        //4*5-8+60+8/2 ==> 4 5 * 8 - 60 + 8  2 / +
        String suffixExpression="3 4 + 5 * 6 -";
        String suffixExpression2="4 5 * 8 - 60 + 8 2 / +";
        List<String> listString = getListString(suffixExpression2);
        System.out.printf("计算的结果为%d\n",calculate(listString));
    }


    /**
     *将一个逆波兰表达式放入ArrayList中，方便进行遍历判断。
     * @param s 返回的list里面存有各个元素
     * @return
     */
    public static List<String> getListString (String s){
        String[] strings=s.split(" ");
        List<String> list=new ArrayList<>();
        for (String string : strings) {
            list.add(string);
        }
        return list;
    }

    public static int calculate(List<String> strings){
        //创建堆栈
        Stack<String> stack=new Stack<>();
        for (String s : strings) {
            if (s.matches("\\d+")){  //匹配到多个数字
                stack.push(s);
            }else {
                int num2=Integer.parseInt(stack.pop());
                int num1=Integer.parseInt(stack.pop());
                int res=0;
                if (s.equals("+")){
                    res=num1+num2;
                }else if (s.equals("-")){
                    res=num1-num2;
                }else if (s.equals("*")){
                    res=num1*num2;
                }else if (s.equals("/")){
                    res=num1/num2;
                }else {
                    throw new RuntimeException("运行符号有问题");
                }
                stack.push(res+"");
            }
        }
        //最后留在栈里的值就是结果
        return Integer.parseInt(stack.pop());
    }
}
