import java.util.concurrent.locks.ReentrantLock;

public class Testlock {
    public static void main(String[] args) {
        // 创建一个售票线程
        TicketSellingThread ticketThread = new TicketSellingThread();

        // 创建多个线程并启动它们
        int numThreads = 5; // 例如，创建5个售票窗口
        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(ticketThread);
            thread.start();
        }
    }
}

class TicketSellingThread implements Runnable {
    private final ReentrantLock lock = new ReentrantLock();
    private int ticketNums = 10; // 假设有10张票可售

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock(); // 获取锁
                if (ticketNums > 0) {
                    System.out.println("Ticket Number: " + ticketNums);
                    ticketNums--;
                    Thread.sleep(1000); // 模拟处理时间
                } else {
                    break; // 所有票已售完，退出循环
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock(); // 释放锁
            }
        }
    }
}
