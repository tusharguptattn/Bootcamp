package Concurrent;

public class BankAccountMain {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        Runnable task = () -> bankAccount.withdraw(50000);
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();


    }
}
