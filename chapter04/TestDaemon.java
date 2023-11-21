package chapter04;

public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread Thread = new Thread(god);

    }
}

class You implements Runnable {
    public void run() {
        for (int i = 0; i < 30000; i++) {
            System.out.println("活一下");
        }
    }
}

class God implements Runnable {
    public void run() {
        while (true) {
            System.out.println("god活着");
        }
    }
}