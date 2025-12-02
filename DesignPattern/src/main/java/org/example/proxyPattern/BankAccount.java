package org.example.proxyPattern;

public class BankAccount implements Account{

    @Override
    public void withdraw() {
        System.out.println("Withdrawing is in process");
    }

    @Override
    public void getAccountBalance() {
        System.out.println("Your Account balance is --");

    }
}
