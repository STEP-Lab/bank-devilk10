package com.thoughtworks.step_bank;

public class Account {
    private final String accountNumber;
    private double balance;


    public Account(String accountNumber, double balance) throws InvalidAccountNumberException, LowAmountException {
        if (incorrectAccountNumberPattern(accountNumber)) {
            throw new InvalidAccountNumberException();
        }
        if (balance<100){
            throw new LowAmountException("Insufficient account balance to create account");
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
            throw new LowAmountException("Invalid credit request");
        }
        balance+=amount;
        return balance;
    }

    public boolean canCredit(int amount) {
        return amount>0;
    }

    public double debit(int amount) throws LowAmountException {
        if (!canDebit(amount)) {
            throw new LowAmountException("Can't process your debit request due to low balance");
        }
        balance-=amount;
        return balance;
    }

    public boolean canDebit(int amount) {
        return balance-amount>100;
    }
}
