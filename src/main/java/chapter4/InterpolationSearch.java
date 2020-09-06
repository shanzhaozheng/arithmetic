package chapter4;

public class InterpolationSearch {

    public static void main(String[] args) {
        int [] arr = {1,2,1,6,8,9,55,62,66,77,99};
        System.out.println(interpolationSearch(arr, 66));
    }

    /**
     * 插值查找算法
     * @param arr
     * @param value
     * @return
     */
    public static int interpolationSearch(int [] arr,int value){
        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi){
            int mid = lo + (hi - lo) * (value - arr[lo]) / (arr[hi] -arr[lo]);
            if (value > arr[mid]) lo = mid + 1;
            else if (value < arr[mid]) hi = mid - 1;
            else return mid;
        }
        return -1;
    }
}
