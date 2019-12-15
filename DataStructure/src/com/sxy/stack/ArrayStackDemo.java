package com.sxy.stack;

/**
 * 需求：实现一个计算器
 * 中缀表达式
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        String expression ="7+2*6-4";  //计算的表达式
        //创建两个栈
        ArrayStack numStack=new ArrayStack(10);
        ArrayStack operStack=new ArrayStack(10);
        int index=0;//用于扫描
        int num1,num2,oper,res=0;
        char ch=' ';
        String keepNum="";//用于拼接多位数
        while (true){
            //拿到每一个字符
            ch=expression.substring(index,index+1).charAt(0);
            //判断这个字符是什么
            if (operStack.isOper(ch)){  //如果是字符
                if (operStack.isEmpty()){
                    operStack.push(ch);
                }else {
                    //如果这个条件满足，就从数组中pop出两个数进行运算。
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())){
                            num1 = numStack.pop();
                            num2 = numStack.pop();
                            oper = operStack.pop();
                            res = numStack.cal(num1, num2, oper);
                            //将计算出的值入数栈
                            numStack.push(res);
                            operStack.push(ch);
                }else {
                        operStack.push(ch);
                    }
                }
            }else {  //如果是数字
                numStack.push(ch-48);  //不能强转成int
            }
            index++;
            if (index>=expression.length()){
                break;
            }
        }

        //表达式扫描完毕后，进行最后的计算，通过判断符号栈是否为空来进行循环
        while (true){
            if (operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            //将计算出的值入数栈
            numStack.push(res);
        }
        //将数栈的最后pop出来。
        System.out.printf("表达式%s的结果是:%d\n",expression,numStack.pop());
    }
}

//数组模拟栈,并添加了几个计算器使用的方法。
class ArrayStack{
    private int maxsize;
    private int[] stack;
    private int top=-1;

    public ArrayStack(int maxsize){
        this.maxsize=maxsize;
        stack=new int[this.maxsize];
    }

    //栈满
    public boolean isFull(){
        return top==maxsize-1;
    }

    //栈空
    public boolean isEmpty(){
        return top==-1;
    }

    //查看栈顶的值，但不是真正的弹出栈
    public int peek(){
        return stack[top];
    }
    //压入数据
    public void push(int val){
        if (isFull()){
            System.out.println("栈满，无法放入数据");
            return;
        }
        top++;
        stack[top]=val;
    }
    //弹出数据
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空,无数据");
        }
        int val=stack[top];
        top--;
        return val;
    }

    //显示栈
    //遍历时，需要从栈顶开始显示数据
    public void list(){
        if (isEmpty()){
            System.out.println("栈空，无数据");
            return;
        }
        for (int i = top; i >=0 ; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }

    //返回此时运算符的优先级。优先级是程序员来确定的。数字越大，优先级越高。
    //假设计算只存在加减乘除。
    public int priority(int oper){
        if (oper=='*'||oper=='/'){
            return 1;
        }else if (oper=='+'||oper=='-'){
            return 0;
        }else {
            return -1;
        }
    }

    //判断是运算符还是数字
    public boolean isOper(int val){
        return val=='*'||val=='/'||val=='+'||val=='-';
    }

    //将弹出的值进行计算

    /**
     *
     * @param num1  先弹出的数
     * @param num2  后弹出的数
     * @param oper  运算符
     * @return
     */
    public int cal(int num1,int num2,int oper){
        int res=0;
        switch (oper){
            case '+':
                res=num1+num2;
                break;
            case '-':
                res=num2-num1;
                break;
            case '*':
                res=num1*num2;
                break;
            case '/':
                res=num2/num1;
                break;
            default:
                break;
        }
        return res;
    }



}
