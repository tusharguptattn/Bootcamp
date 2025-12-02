package Concurrent;

public class RaceConditionEx {

    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                c.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.join();

        System.out.println(c.count); // NOT 2000 most of the times

    }
}




class Counter {
    int count = 0;

    synchronized void  increment() {
        count++;
    }
}

