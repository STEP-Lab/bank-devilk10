package com.thoughtworks.step_bank;

public class Account {
    private final String accountNumber;
    private int balance;


    public Account(String accountNumber, int balance) throws MinimumBalanceException, InvalidAccountNumberException {
        if (incorrectAccountNumberPattern(accountNumber)) {
            throw new InvalidAccountNumberException();
        }
        if (balance<100){
            throw new MinimumBalanceException();
        }
        this.accountNumber=accountNumber;
        this.balance=balance;
    }

    private boolean incorrectAccountNumberPattern(String accountNumber) {
        return !accountNumber.matches("^\\d{4}-\\d{4}$");
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public int credit(int amount) {
        balance+=amount;
        return balance;
    }

    public int debit(int amount) throws MinimumBalanceException{
        if (balance-amount<100){
            throw new MinimumBalanceException();
        }
        balance-=amount;
        return balance;
    }
}
