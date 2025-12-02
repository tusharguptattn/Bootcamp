package Concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ConcurrencyClass {


    public static void main(String[] args) {

        // Task 1 code
        MyThread  myThread = new MyThread();
        Thread thread = new Thread(myThread);
        thread.start();

    // Task 2 code
        MyThreadCall my = new MyThreadCall();
        FutureTask<String> f = new FutureTask<>(my);
        Thread thread1 = new Thread(f);
        thread1.start();

        try {
            System.out.println(f.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }



        // Task 3 one-line answer
        //  Becuase run method do not create any thread , only start craete the threadm if we write run method instead of start , as we have created any thread and we are running it



        /*
        Quiz answers

New
no
join()
*
* */


    }
}


class MyThread implements Runnable{

    @Override
    public void run() {
        for(int i=1;i<6;i++){
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


class MyThreadCall implements Callable<String> {

    @Override
    public String call() throws InterruptedException {
                Thread.sleep(200);
                return "DONE";
    }
}










