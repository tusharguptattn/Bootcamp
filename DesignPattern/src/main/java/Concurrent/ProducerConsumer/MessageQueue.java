package Concurrent.ProducerConsumer;

import java.util.ArrayList;
import java.util.List;

public class MessageQueue {

    private List<Integer> list = new ArrayList<>();
    String msg;
    private boolean empty = true;

    public synchronized void put(String msg) throws InterruptedException {
        while(!empty){
            wait();
        }
        this.msg = msg;
        empty = false;
        System.out.println("Produced" + msg);
        notify();
    }


    public synchronized String take() throws InterruptedException {
        while(empty){
            wait();
        }
        empty = true;
        System.out.println("Consumed "+msg);
        notify();
        return msg;

    }


}




