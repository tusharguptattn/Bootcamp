package Concurrent.ProducerConsumer;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

        ExecutorService es = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 4; i++) {
            es.submit(new Produce(queue));
            es.submit(new Consumer(queue));
        }






//        Thread consumer = new Thread(new Consumer(queue));
//        Thread producer = new Thread(new Produce(queue));
//        consumer.start();
//        producer.start();
        es.shutdown();
    }
}
