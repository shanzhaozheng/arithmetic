package chapter02;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LinkedQueue<T> extends LinkedBlockingQueue<T> {

    private Node first;

    private Node last;

    private AtomicInteger count = new AtomicInteger(0);

    private int max = 10;

    private Lock lock = new ReentrantLock();

    private Condition notFull=lock.newCondition();


    public LinkedQueue() {
    }

    public LinkedQueue(int max) {
        this.max = max;
    }



    @Override
    public int size() {
        return count.get();
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }


    @Override
    public Iterator<T> iterator() {
        return this.new Itr();
    }

    /**
     * 超时抛弃
     * @param t 数据
     * @param timeout 时间
     * @param unit 时间类型
     * @return
     */
    @Override
    public boolean offer(T item, long timeout, TimeUnit unit){
        Node node = new Node();
        node.item=item;
        long nanos = unit.toNanos(timeout);
        lock.lock();
        try {
            while (count.get() == max) {
                if (nanos <= 0)
                    return false;
                nanos = notFull.awaitNanos(nanos);
            }
            count.getAndIncrement();
            Node oldLastNode = last;
            last = node;
            if (isEmpty()) first = last;
            else oldLastNode.next = node;
            System.out.println(item+"入队");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
        }
        return true;
    }

    @Override
    public T poll() {
        T result = null;
        lock.lock();
        try {
            if (count.get() > 0) {
                result = first.item;
                first = first.next;
                count.decrementAndGet();
                System.out.println(result+"出队");
                notFull.signal();
            }else System.out.println("出队失败");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return result;
    }

    @Override
    public T element() {
        if (last == null) throw new NoSuchElementException();
        return first.item;
    }

    @Override
    public T peek() {
        return first == null ? null : first.item;
    }


    private class Itr implements Iterator<T>{

        private Node current;

        private boolean flag = true;

        @Override
        public boolean hasNext() {
            if (flag) {
                synchronized (Itr.class){
                    if (flag){
                        current = first;
                        flag=false;
                    }
                }
            }
            return current != null;
        }

        @Override
        public T next() {
            T result = current.item;
            current=current.next;
            return result;
        }
    }

    private class Node{
        T item;
        Node next;
    }


    /**
     * 并发测试
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        LinkedQueue<Integer> objects = new LinkedQueue(3);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(18, () -> {
            System.out.println("================");
            Iterator<Integer> iterator = objects.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
            System.out.println(objects.peek());
        });


        for (int i = 0; i < 9; i++) {
            final int tmp = i;
            new Thread(() -> {
                objects.offer(tmp, 2, TimeUnit.SECONDS);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },"入队线程").start();

            new Thread(() -> {
                objects.poll();
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },"出队线程").start();
        }


    }
}




