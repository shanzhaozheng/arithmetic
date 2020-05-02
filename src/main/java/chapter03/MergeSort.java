package chapter03;

public class MergeSort {

    public static void main(String[] args) {
        int [] arr = {20,9,-1,10,3,100,-1,-9,10,20,100,5,7,3,5,6,45,68};
        mergeSort(arr,0,arr.length -1,new int[arr.length]);
        for (int ccc : arr) {
            System.out.print(ccc+ " ");
        }
    }

    public static void mergeSort(int [] arr,int left,int right,int[] tmp){
        if (left < right){
            int mid = (left + right)/2;
            mergeSort(arr,left,mid,tmp);
            mergeSort(arr,mid + 1,right,tmp);
            merge(arr,left,mid,right,tmp);

        }

    }

    public static void merge(int [] arr,int left,int mid,int right,int [] tmp){
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right){
            if (arr[i] < arr[j]){
                tmp[t++] = arr[i++];
            }else {
                tmp[t++] = arr[j++];
            }
        }
        while (i <= mid){
            tmp[t++] = arr[i++];
        }
        while (j <= right){
            tmp[t++] = arr[j++];
        }
        t = 0;
        while (left <= right){
            arr[left++] = tmp[t++];
        }
    }

}
