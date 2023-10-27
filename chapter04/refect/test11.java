package chapter04.refect;

import java.util.ArrayList;

public class test11 {
    public static void main(String[] args) throws InterruptedException {
        CreateList.createList();
    }
}

class CreateList {
    static void createList() throws InterruptedException {
        ArrayList<Integer> list = new ArrayList<Integer>();
        // Vector<Integer> list = new Vector<>();
        // CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                synchronized (list) {
                    list.add(0);
                }
            }).start();
        }
        Thread.sleep(100);
        System.out.println(list.size());
    }
}