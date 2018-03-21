package com.thoughtworks.step_bank;

public class Account {
    private final String accountNumber;
    private double balance;


    public Account(String accountNumber, double balance) throws MinimumBalanceException, InvalidAccountNumberException {
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

    public double getBalance() {
        return balance;
    }

    public double credit(int amount) throws LowAmountException{
        if(!canCredit(amount)){
            throw new LowAmountException();
        }
        balance+=amount;
        return balance;
    }

    public boolean canCredit(int amount) {
        return amount>0;
    }

    public double debit(int amount) throws MinimumBalanceException {
        if (!canDebit(amount)) {
            throw new MinimumBalanceException();
        }
        balance-=amount;
        return balance;
    }

    private boolean canDebit(int amount) {
        return balance-amount>100;
    }
}
