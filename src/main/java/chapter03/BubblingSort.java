package chapter03;

public class BubblingSort {

    public static void main(String[] args) {
        int [] arr = {20,9,-1,10,3};
        bubblingSort(arr);
        for (int anInt : arr) {
            System.out.print(anInt+" ");
        }
    }

    public static void bubblingSort(int [] arr){
        int tmp = 0;
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]){
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    count++;
                }
                flag = true;
            }
            if (flag) {
                System.out.println("执行"+count+"次");
                return;
            }
        }
        System.out.println("执行"+count+"次");
    }



}
