package chapter01;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找
 */
public class BinarySearch {

    /**
     * 二分查找(单个)
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearch(int [] arr, int target){
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

    /**
     * 二分查找(多个)
     * @param arr
     * @param target
     * @param lo
     * @param hl
     * @param result
     * @return
     */
    public static List<Integer> binarySearch(int [] arr,int target,int lo,int hl,ArrayList<Integer> result){
        int mid = 0;
        while (lo <= hl){
            mid = lo + (hl - lo)/2;
            if (target > arr[mid]) lo = mid + 1;
            else if (target < arr[mid]) hl = mid - 1;
            else {
                result.add(mid);
                binarySearch(arr,target,mid + 1,hl,result);
                binarySearch(arr,target,lo,mid - 1,result);
                return result;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,1,6,8,9,62,77,55,66,99};
        System.out.println(binarySearch(arr, 54));
        System.out.println(binarySearch(arr, 1, 0, arr.length - 1, null));
    }
}
