package Concurrent;

import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class AtomicInteger1 {

    public static void main(String[] args) throws InterruptedException {
//        AtomicInteger counter = new AtomicInteger(0);
        LongAdder longAdder = new LongAdder();

        ExecutorService es = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 1000; i++) {
            es.submit(longAdder::increment);
        }

        es.shutdown();
        es.awaitTermination(5, TimeUnit.SECONDS); //
        System.out.println(longAdder.sum());

    }

}
