package chapter03;

public class ShellSort {

    public static void main(String[] args) {
        int [] arr = {20,9,-1,10,3,100,-1,-9,10,20,100,5,7,3,5,6,45,68};
        shellSort2(arr);
        for (int anInt : arr) {
            System.out.print(anInt + " ");
        }
    }

    /**
     * 交换法
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int temp = 0;
        for (int i = arr.length / 2; i > 0; i /= 2) {
            for (int j = i; j < arr.length; j++) {
                for (int k = j - i; k >= 0; k -= i) {
                    if (arr[k] > arr[k + i]) {
                        temp = arr[k];
                        arr[k] = arr[k + i];
                        arr[k + i] = temp;
                    }
                }
            }
        }
    }

    /**
     * 移动法
     * @param arr
     */
    public static void shellSort2(int[] arr) {
        for (int i = arr.length / 2; i > 0; i /= 2) {
            for (int j = i; j < arr.length; j++) {
                int insertIndex = j;
                int insertValue = arr[insertIndex];
                while (insertIndex - i >= 0 && insertValue < arr[insertIndex -i]){
                    arr[insertIndex] = arr [insertIndex - i];
                    insertIndex -= i;
                }
                arr[insertIndex] = insertValue;
            }

        }
    }
}
