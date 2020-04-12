package chapter03;

public class Queue8 {

    //定义一个max表示共有多少个皇后
    int max = 8;
    static int count;
    int[] arr = new int[max];
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println("一共"+count+"总算法");
    }

    private void check(int n){
        if (n == max){
            print();
            count++;
            return;
        }

        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if (judge(n)){
                check(n+1);
            }

        }
    }

    private boolean judge(int index){
        for (int i = 0; i < index; i++) {
            if (arr[index] == arr[i] || Math.abs(index - i) == Math.abs(arr[index] - arr[i]))
                return false;
        }
        return true;
    }

    private void print(){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


}
