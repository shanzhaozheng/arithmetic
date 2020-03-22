package chapter01;

/**
 * 二分查找
 */
public class BinarySearch {

    /**
     * 二分查找
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearch(int [] arr,int target){
        int lo = 0;
        int hl = arr.length-1;
        int mid = 0;
        while (lo <= hl){
            mid = lo + (hl - lo)/2;
            if (target > arr[mid]) lo = mid + 1;
            else if (target < arr[mid]) hl = mid - 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,5,6,8,9,62,77,55,66,99};
        System.out.println(binarySearch(arr, 54));
    }
}
