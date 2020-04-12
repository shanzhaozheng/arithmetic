package chapter03;

public class SelectionSort {

    public static void main(String[] args) {
        int [] arr = {20,9,-1,10,3};
        selectionSort(arr);
        for (int anInt : arr) {
            System.out.print(anInt+" ");
        }
    }

    public static void selectionSort(int [] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]){
                    minIndex = j;
                    min = arr[j];
                }

            }
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
