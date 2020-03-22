package chapter02;

import java.util.Iterator;
import java.util.Stack;

/**
 * 链表结构 Stacke
 */
public class LinkedStack<T> extends Stack<T> {

    private Node first;

    private int count;


    public LinkedStack() {
        super();
    }

    @Override
    public T push(T item) {
        Node oldFirst = first;
        Node node = new Node();
        node.item = item;
        node.next = oldFirst;
        first = node;
        count++;
        return node.item;
    }

    @Override
    public synchronized T pop() {
        Node result = first;
        first = first.next;
        count--;
        return result.item;
    }

    @Override
    public synchronized T peek() {
        return first.item;
    }

    @Override
    public boolean empty() {
        return first == null;
    }

    public int size(){
        return count;
    }

    @Override
    public synchronized Iterator<T> iterator() {
        return this.new Itr();
    }

    private class Itr implements Iterator<T>{

        Node cpNode;
        boolean flag = true;

        @Override
        public boolean hasNext() {
            if (flag) {
                synchronized (Itr.class){
                    if (flag){
                        flag = false;
                        cpNode = first;
                    }
                }
            }
            return cpNode != null;
        }

        @Override
        public T next() {
            Node result = cpNode;
            cpNode = cpNode.next;
            return result.item;
        }

    }

    private class Node{
        T item;
        Node next;
    }
}
