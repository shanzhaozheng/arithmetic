package chapter02.link;

public class CircularlinkedList {

    private Node first;

    public CircularlinkedList(int head) {
        this.add(head);
    }

    private void add(int head){
        if (head <= 0) return;
        Node curNode = null;
        for (int i = 1; i <= head; i++) {
            Node node = new Node(i);
            if (i == 1){
                first = node;
                first.next = first;
                curNode = node.next = first;
            }else {
                curNode.next = node;
                curNode = node;
                curNode.next=first;
            }
        }
    }


    /**
     * 约瑟夫⚪
     * 思路： 头尾移动
     * @param m 每次移动步数
     * @return
     */
    public void kill(int m){
        if (first == null) return;
        Node helper = first;
        while (helper.next != first){
            helper = helper.next;
        }
        while (helper != first){
            for (int i = 0; i < m - 1; i++) {
                helper = helper.next;
                first = first.next;
            }
            System.out.printf("删除%s编号\n",first.number);
            first = first.next;
            helper.next = first;
        }
        System.out.printf("吃鸡小伙编号：%s\n",first.number);
    }

    private class Node{
        int number;

        Node next;

        public Node(int number) {
            this.number = number;
        }

    }

    public static void main(String[] args) {
        CircularlinkedList circularlinkedList = new CircularlinkedList(102);
        circularlinkedList.kill(2);
    }
}
