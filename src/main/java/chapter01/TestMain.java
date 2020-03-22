package chapter01;

import java.util.Random;

/**
 * 基础练习
 */
public class TestMain {
    public static void main(String[] args) {
        System.out.println(2.0e-6*1.1);
        System.out.println((2.0e-6)*100000000.1);
        System.out.println(false && true );
        System.out.println((1+2.236)/2);
        System.out.println(1+2+3+4.0);
        System.out.println(4.1 >= 4);
        System.out.println(1+2+"3");

        int [] arr = {1,1,1,1,1,1,1,};
        System.out.println(method1(0, arr));
        System.out.println(method2(1.0,0.1));
        method3();

        System.out.println((char) ('a'+4));

        System.out.println(method4(50));

        boolean [][] barr =new boolean[5][5];
        Random random = new Random();
        for (int i = 0; i < barr.length; i++) {
            for (int i1 = 0; i1 < barr[i].length; i1++) {
                barr[i][i1]=random.nextInt()>5;
            }
        }
        System.out.println("=====");
        method5(barr);

        int arr2[][] = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        printArray(arr2);
        printArray(method6(arr2));
    }

    /**
     * 求数组数据必须相同
     * @param lo
     * @param number
     * @return
     */
    public static boolean method1(int lo,int [] number){
        if (lo == number.length-1){
            return true;
        }
        if (number[lo] != number[lo+1]){
            return false;
        }else {
            return method1(lo+1,number);
        }

    }

    /**
     * 求两数必须在0~1之间
     * @param x
     * @param y
     * @return
     */
    public static boolean method2(double x,double y){
        return  x >= 0 && x <= 1 && y >= 0 && y >= 0;
    }

    /**
     * 变量的交换
     */
    public static void method3(){
        int f = 0;
        int g = 1;
        for (int i = 0; i < 16; i++) {
            System.out.println(f);
            f=f+g;
            g=f-g;
        }
    }


    /**
     * int二进制转换
     * @param N
     * @return
     */
    public static String method4(int N){
        String s="";
        for (int n = N; n>0; n/=2) {
            s=(n%2)+s;
        }
        return s;
    }


    /**
     * 打印二维boolean数组 并打印行列号
     * true : *
     * false: " "
     *
     * @param arr
     */
    public static void method5(boolean[][] arr){
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 ){
                System.out.print(" ");
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(j+1);
                }
                System.out.println();
                System.out.print(i+1);
            }else {
                System.out.print(i+1);
            }
            for (int i1 = 0; i1 < arr[i].length; i1++) {
                if (arr[i][i1]) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    /**
     *
     *
     * @param arr 数据原
     * @param <T> 数据类型
     * @return
     */
    public static int[][] method6(int [][] arr){
        int [][] rarr = new int [arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                rarr[i][j] = arr[j][i];
            }
        }
        return rarr;
    }

    /**
     * 遍历数组并输出数组的全部元素
     */
    private static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {// 遍历数组
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");// 不换行输出数组元素
            }
            System.out.println();	//换行
        }
    }
}
