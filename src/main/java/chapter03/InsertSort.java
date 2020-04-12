package chapter03;

public class InsertSort {

    public static void main(String[] args) {
        int [] arr = {20,9,-1,10,3};
        insertSort(arr);
        for (int anInt : arr) {
            System.out.print(anInt+" ");
        }
    }

    public static void insertSort(int [] arr){
        for (int i = 1; i < arr.length; i++) {
            int insertIndex = i - 1;
            int insertValue = arr[i];
            while (insertIndex >= 0 && insertValue < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertValue;
            }
        }
    }


}
