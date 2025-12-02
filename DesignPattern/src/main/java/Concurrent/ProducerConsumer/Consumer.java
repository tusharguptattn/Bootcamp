package Concurrent.ProducerConsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    private BlockingQueue<Integer> messageQueue;

    public Consumer(BlockingQueue<Integer> queue){
        this.messageQueue=queue;
    }

    @Override
    public void run() {
        try {
            for(int i=1;i<=10;i++) {
                int take = messageQueue.take();
                System.out.println("Consumed "+take);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
