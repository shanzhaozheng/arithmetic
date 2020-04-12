package chapter02.queue;


import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ArrayQueue<T> implements Queue<T> {

    private T arr[];

    private int font = 0;

    private int rear = 0;

    /**
     *  因下标从0开始，所以取模算法也需要 n+1 最大模型
     *  实际队列大小为 3 ，因为下标为 3 的下标会被跳过
     */
    private int MaxSize = 4;

    public ArrayQueue() {
        arr = (T[])new Object[MaxSize];
    }

    public ArrayQueue(int maxSize) {
        MaxSize = maxSize;
        arr = (T[])new Object[MaxSize+1];
    }


    @Override
    public boolean offer(T o) {
        if (isFull()){
            return false;
        }
        arr[rear] = o;
        rear = (rear+1)%MaxSize;
        return true;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public T poll() {
        if (isEmpty()){
            return null;
        }
        T result = arr[font];
        font = (font+1)%MaxSize;
        return result;
    }

    @Override
    public T element() {
        if (size() == 0 ) throw new NoSuchElementException();
        T result=arr[font];

        return result;
    }

    @Override
    public T peek() {
        return arr[font];
    }

    private boolean isFull(){
        return (rear+1)%MaxSize == font;
    }


    @Override
    public int size() {
        return (rear+MaxSize-font) % MaxSize;
    }

    @Override
    public boolean isEmpty() {
        return font == rear;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> integers = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            integers.offer(i);
        }
        System.out.println(integers.peek());
        System.out.println(integers.size());
        for (int i = 0; i < 10; i++) {
            System.out.println(integers.poll());
        }
    }
}
