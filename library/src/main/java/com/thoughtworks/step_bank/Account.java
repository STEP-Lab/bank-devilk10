package com.thoughtworks.step_bank;

public class Account {
    private final String accountNumber;
    private int balance;


    public Account(String accountNumber, int balance) throws MinimumBalanceException {
        this.accountNumber=accountNumber;
        if (balance<100){
            throw new MinimumBalanceException();
        }
        this.balance=balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }
}
