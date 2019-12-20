package com.sxy.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 需求：逆波兰表达式的计算
 * 将一个中缀表达式转成后缀表达式
 */
public class PolandNotation {
    public static void main(String[] args) {
        List<String> zhongString = getZhongString("1+((2+3)*4)-5"); //得到了相应的中缀表达式集合。
        System.out.println(zhongString);
        List<String> strings = zhongToHou(zhongString);
        System.out.println(strings);
        //此时已经拿到一个后缀表达式了
        int calculate = calculate(strings);
        System.out.printf("此方程的结果是:%d",calculate);
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

    /**
     * 计算相应的逆序表达式。
     * @param strings
     * @return
     */
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

    /**
     * 将中缀表达式放入一个List中。
     * @param s
     * @return
     */
    public static List<String> getZhongString(String s){
        ArrayList<String> strings = new ArrayList<>();
        char c;  //存放遍历的字符
        String str; //存放拼接的字符
        int i=0;  //计数
        while (i<s.length()){
            if ((c=s.charAt(i))<48||(c=s.charAt(i))>57){
                strings.add(c+"");
                i++;
            }else {
                str="";
                while (i<s.length()&&(c=s.charAt(i))>=48&&(c=s.charAt(i))<=57){
                    str+=c;
                    i++;
                }
                strings.add(str);
            }
        }
        return strings;
    }

    /**
     * 中缀表达式转成后缀表达式
     * @param strings
     * @return
     */
    public static List<String> zhongToHou(List<String> strings){
        Stack<String> s1 = new Stack<>();  //用于存放比较符号的
        ArrayList<String> s2 = new ArrayList<>();  //用于存放最终输出的后缀表达式的
        //遍历strings
        for (String s : strings) {
            if (s.matches("\\d+")){
                s2.add(s);
            }else if (s.equals("(")){
                s1.push(s);
            }else if (s.equals(")")){
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();
            }else {
                //需要在此处判断运算符的优先级。
                while (s1.size()!=0&&(Operation.priority(s1.peek())>=Operation.priority(s))){
                    s2.add(s1.pop());
                }
                s1.push(s);
            }
        }
        while (s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;
    }

}

class Operation{
    /**
     * 返回优先级
     * @param s
     * @return
     */
    public static int priority(String s){
        int result=0;
        switch (s){
            case "+":
                result=1;
                break;
            case "-":
                result=1;
                break;
            case "*":
                result=2;
                break;
            case "/":
                result=2;
                break;
            default:
                break;
        }
        return result;
    }
}
