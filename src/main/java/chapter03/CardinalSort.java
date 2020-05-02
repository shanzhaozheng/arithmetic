package chapter03;

public class CardinalSort {
    public static void main(String[] args) {
        int [] arr = {20,9,10,3,100,10,20,100,5,7,3,5,6,45,68};
        cardinalSort(arr);
        for (int ccc : arr) {
            System.out.print(ccc+ " ");
        }
    }

    public static void cardinalSort(int [] arr){
        int max = 0;
        for (int i : arr) {
            if (i > max) max = i;
        }
        int length = (max + "").length();

        int [] bucketCount = new int[10];

        for (int i = 0,j = 1; i < length; i++,j *= 10) {
            int [][] bucket = new int[10][arr.length];

            for (int k = 0; k < arr.length; k++) {
                int a = arr[k] / j % 10;
                bucket[a][bucketCount[a]++] = arr[k];
            }

            for (int k = 0,m = 0; k < bucket.length; k++) {
                int index = 0;
                while (bucketCount[k] > 0){
                    arr[m++] = bucket[k][index++];
                    bucketCount[k]--;
                }
            }
        }
    }
}
