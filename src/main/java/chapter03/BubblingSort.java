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
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]){
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }



}
