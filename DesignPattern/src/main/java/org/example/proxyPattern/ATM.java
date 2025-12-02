package org.example.proxyPattern;
// Proxy for Bank Account
public class ATM implements Account{

    @Override
    public void withdraw() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.withdraw();
    }

    @Override
    public void getAccountBalance() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.getAccountBalance();
    }
}
