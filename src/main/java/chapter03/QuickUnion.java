package chapter03;

public class QuickUnion {
    int [] arr;
    int count;

    public QuickUnion(int capacity) {
        arr = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            arr[i] = i;
        }
        count = capacity;
    }

    public void union(int p,int q){
        int rootp = find(p);
        int rootq = find(q);
        if (rootp == rootq) return;
        arr[rootp] = rootq;
    }

    public int find(int p){
        while (arr[p] != p) p = arr[p];
        return p;
    }

    public boolean connected(int p ,int q){
        return arr[p] == q;
    }

    public static void main(String[] args) {

    }


}
