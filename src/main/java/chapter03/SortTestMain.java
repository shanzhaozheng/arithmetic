package chapter03;

public class SortTestMain {



    public static void main(String[] args) {
        int [] arr = {20,9,-1,10,3,100,-1,-9,10,20,100,5,7,3,5,6,45,68};


        quickSort(arr,0,arr.length -1);
        for (int ccc : arr) {
            System.out.print(ccc+ " ");
        }
    }

    /**
     * 冒泡
     * O(n^2)
     * @param arr
     */
    public static void bubblingSort(int [] arr){
        int temp = 0;
        boolean flag = true;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) return;
        }
    }


    /**
     * 选择
     * O(n^2)
     * @param arr
     */
    public static void selectSort(int [] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int midIndex = i;
            int midValue = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (midValue > arr[j]){
                    midIndex = j;
                    midValue = arr[j];
                }
            }
            if (midIndex != i){
                arr[midIndex] = arr[i];
                arr[i] = midValue;
            }
        }
    }

    /**
     *  插入排序
     *  O(n^2)
     * @param arr
     */
    public static void insertSort(int [] arr){
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if ((insertIndex + 1) != i){
                arr[insertIndex + 1] = insertValue;
            }

        }
    }


    /**
     * 希尔排序：交换法
     * @param arr
     */
    public static void shellSort1(int [] arr){
        int tmp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap ; i < arr.length; i++) {
                for (int j = i - gap ; j >= 0 ; j -= gap) {
                    if (arr[j] > arr[j + gap]){
                        tmp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = tmp;
                    }
                }
            }
        }
    }


    /**
     * 希尔排序: 移动法
     * @param arr
     */
    public static void shellSort2(int [] arr){
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap ; i < arr.length; i++) {
                int insertIndex = i;
                int insertValue = arr[i];
                while (insertIndex - gap >= 0 && insertValue < arr[insertIndex - gap]){
                    arr[insertIndex] = arr[insertIndex - gap];
                    insertIndex -= gap;
                }
                arr[insertIndex] = insertValue;
            }
        }
    }

    /**
     * 快速排序
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int [] arr ,int left,int right){
        if (left >= right) return;
        int l,r,tmp,standard;
        l = left;
        r = right;
        tmp = 0;
        standard = arr[left];
        while (l != r){
            while (l < r && arr[r] >= standard){
                r--;
            }
            while (l < r && arr[l] <= standard){
                l++;
            }
            tmp = arr[r];
            arr[r] = arr[l];
            arr[l] = tmp;

        }
        arr[left] = arr[l];
        arr[l] = standard;
        quickSort(arr,left,r - 1);
        quickSort(arr,l + 1 ,right);
    }


}
