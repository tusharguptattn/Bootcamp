package Concurrent.ProducerConsumer;



import java.util.concurrent.BlockingQueue;

public class Produce implements Runnable {
    private BlockingQueue<Integer> queue;

    public Produce(BlockingQueue<Integer> queue){
        this.queue= queue;
    }

    @Override
    public void run() {
        try {
            for(int i=1;i<=10;i++) {
                queue.put(i);
                System.out.println("Produced "+i);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
