package Concurrent;

import java.util.concurrent.locks.ReentrantLock;
class BankAccount {

    int balance = 100000;
    private ReentrantLock lock = new ReentrantLock();

    public void withdraw(int amount) {

        if (lock.tryLock()) {
            try {
                System.out.println(Thread.currentThread().getName() + " got the lock");
                System.out.println(Thread.currentThread().getName() + " trying to withdraw...");

                if (balance >= amount) {
                    balance -= amount;
                    System.out.println(Thread.currentThread().getName() + " withdrawn successfully");
                    System.out.println("Amount left: " + balance);
                } else {
                    System.out.println("Not enough balance");
                }

            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " could not get lock, doing something else...");
        }
    }
}





