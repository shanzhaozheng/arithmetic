package chapter02.stack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 栈
 * @param <T>
 */
public class FixedCapacityStack<T> implements Iterable<T> {

    private T [] arr;

    private int cap = 10;

    private int N;

    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public FixedCapacityStack() {
    }

    public FixedCapacityStack(int cap) {
        this.cap=cap;
    }

    /**
     * 出栈
     * @return
     */
    public T pop(){
        if (null == arr){
            arr=(T [])new Object[cap];
        }
        if (N > 0 && N == arr.length/4) {
            reSize(arr.length/2);
        }
        if (N <= 0) throw new EmptyStackException();
        T result=arr[--N];
        arr[N]=null;
        return result;
    }

    /**
     * 入栈
     * @param item
     */
    public void push(T item){
        if (null == arr){
            arr=(T [])new Object[cap];
        }
        if (N == arr.length) reSize(arr.length*2);
        arr[N] = item;
        N++;
    }

    /**
     * 判断栈中是否有元素
     * @return
     */
    public boolean isEmpty(){
        readWriteLock.readLock().lock();
        boolean flag = false;
        try {
            flag = N == 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
        return flag;
    }

    /**
     * 扩容
     * @param size
     */
    private void reSize(int size){
        readWriteLock.readLock().lock();
        T [] cparr = null;
        try {
            cparr = (T[])new Object [size];
            for (int i = 0; i < N; i++) {
                cparr[i] = arr[i];
            }
            readWriteLock.readLock().unlock();
            readWriteLock.writeLock().lock();
            this.arr=cparr;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    /**
     * 元素数量
     * @return
     */
    public int size(){
        readWriteLock.readLock().lock();
        int reult = 0;
        try {
            reult = N;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
        return reult;
    }

    public T peek(){
        if (null == arr){
            return null;
        }
        return arr[N-1];
    }


    @Override
    public Iterator<T> iterator() {
        return this.new Itr();
    }

    private class Itr implements Iterator<T> {

        private int index = N - 1;

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public T next() {
            return arr[--index];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

    }
}


