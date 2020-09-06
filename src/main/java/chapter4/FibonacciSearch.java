package chapter4;

public class FibonacciSearch {

    public static void main(String[] args) {
        int [] arr = {1,2,1,6,8,9,55,62,66,77,99};
        System.out.println(fibonacciSearch(arr, 66));
    }


    /**
     * 斐波那契算法
     * 黄金分割法
     * @param arr
     * @param value
     * @return
     */
    public static int fibonacciSearch(int [] arr,int value){
        int[] fibonacci = fibonacci(arr.length);
        return 1;
    }


    public static int [] fibonacci(int size){
        int [] arr = new int[size];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }
}

