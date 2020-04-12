package chapter02;


import java.util.HashMap;

public class TestMain {
    int num = 1;

    public void incr(){
    }

    public static void main(String[] args){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>(15);
        TestMain testMain = new TestMain();
        for (int i = 0; i < 2000; i++) {
            new Thread(()->{
                testMain.incr();
            }).start();
        }
    }


}
