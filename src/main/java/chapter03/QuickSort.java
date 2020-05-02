package chapter03;

public class QuickSort {


    public static void main(String[] args) {
        int [] arr = {20,9,-1,10,3,100,-1,-9,10,20,100,5,7,3,5,6,45,68};
        quickSort(arr,0,arr.length -1);
        for (int ccc : arr) {
            System.out.print(ccc+ " ");
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
