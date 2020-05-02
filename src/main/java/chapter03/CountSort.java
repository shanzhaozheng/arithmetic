package chapter03;

public class CountSort {
    public static void main(String[] args) {
        int [] arr = {20,9,-1,10,3,100,-1,-9,10,20,100,5,7,3,5,6,45,68};
        countSort(arr);
        for (int anInt : arr) {
            System.out.print(anInt+" ");
        }
    }

    public static void countSort(int [] arr){
        int max = 0;
        int min = 0;
        for (int i : arr) {
            if (i > max) max = i;
            if (i < min) min = i;
        }
        int [] tmp = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            tmp[arr[i] - min]++;
        }

        for (int i = 0,j = 0; i < tmp.length; i++) {
            while (tmp[i] > 0){
                arr[j++] = i + min;
                tmp[i]--;
            }
        }
    }

}
