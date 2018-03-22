package com.thoughtworks.step_bank;


public class Account {
    private final String accountNumber;
    private final String accountHolder;
    private final double minimumBalance = 100;
    private double balance;

    public Account(String accountHolder, String accountNumber, double balance) throws InvalidAccountNumberException, LowAmountException {
        if (incorrectAccountNumberPattern(accountNumber)) {
            throw new InvalidAccountNumberException();
        }
        if (balance<minimumBalance){
            throw new LowAmountException("Insufficient account balance to create account");
        }
        this.accountHolder=accountHolder;
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
        return balance-amount>minimumBalance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getSummary() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountHolder='" + accountHolder + '\'' +
                ", balance=" + balance +
                '}';
    }
}
