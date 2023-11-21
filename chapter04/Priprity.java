package chapter04;

public class Priprity {
    TestPrity t = new TestPrity();

    Thread t1 = new Thread(t)

}

class TestPrity implements Runnable{
    System.out.println(Thread.currentTread().getName() + ":" + Thread.currentTread().getPriority)
}