package generics;

/**
 * @Author: shenge
 * @Date: 2020-04-15 20:09
 * <p>
 * 内部类和泛型实现堆栈。
 */
public class LinkedStack<T> {
    private static class Node<U> {
        U item;  //存值
        Node<U> next; //存堆栈下一个元素

        Node() {
        }

        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }

    }

    private Node<T> top = new Node<>();   //最底下放一个node用于判断end条件。

    public void push(T item) {
        top = new Node<>(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> stringLinkedStack = new LinkedStack<>();
        for (String s : "dasima niu bi ni yi wei ne".split(" ")) {
            stringLinkedStack.push(s);
        }
        String s;
        while ((s = stringLinkedStack.pop()) != null) {
            System.out.println(s);
        }
    }
}
