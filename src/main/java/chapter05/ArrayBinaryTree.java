package chapter05;

public class ArrayBinaryTree {

    private int [] arr;



    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(int index){
        System.out.println(arr[index]);
        int left;
        if ((left = 2 * index + 1) < arr.length){
            preOrder(left);
        }
        int right;
        if ((right = 2 * index + 2) < arr.length){
            preOrder(right);
        }
    }

    public void midOrder(int index){
        int left;
        if ((left = 2 * index + 1) < arr.length){
            midOrder(left);
        }
        System.out.println(arr[index]);
        int right;
        if ((right = 2 * index + 2) < arr.length){
            midOrder(right);
        }
    }

    public void postOrder(int index){
        int right;
        if ((right = 2 * index + 2) < arr.length){
            postOrder(right);
        }
        int left;
        if ((left = 2 * index + 1) < arr.length){
            postOrder(left);
        }
        System.out.println(arr[index]);

    }
}
