package com.thoughtworks.step_bank;


import java.util.ArrayList;

public class Account {
  private final AccountNumber accountNumber;
  private final String accountHolder;
  private final double minimumBalance = 100;
  private double balance;
  private Transactions transaction=new Transactions();
  private ArrayList<Transaction> allTransactions = transaction.allTransaction;

  Account(String accountHolder, String accountNumber, double balance) throws InvalidAccountNumberException, LowAmountException {
    this.accountHolder=accountHolder;
    this.accountNumber=new AccountNumber(accountNumber);
    this.balance=validateBalance(balance);
  }

  private double validateBalance(double balance) throws LowAmountException {
    if (balance < minimumBalance) {
      throw new LowAmountException("Insufficient account balance to create account");
    }
    return balance;
  }

  private String getAccountNumber() {
    return accountNumber.number;
  }

  public double getBalance() {
    return balance;
  }

  public double credit(double amount) throws LowAmountException {
    if (!canCredit(amount)) {
      throw new LowAmountException("Invalid credit request");
    }
    balance += amount;
    transaction.credit(accountHolder,amount);
    return balance;
  }

  public boolean canCredit(double amount) {
    return amount > 0;
  }

  public double debit(double amount) throws LowAmountException {
    if (!canDebit(amount)) {
      throw new LowAmountException("Can't process your debit request due to low balance");
    }
    balance -= amount;
    transaction.debit(accountHolder,amount);
    return balance;
  }

  public boolean canDebit(double amount) {
    return balance - amount > minimumBalance;
  }

  public String getAccountHolder() {
    return accountHolder;
  }

  public String getSummary() {
    return "Account{" +
               "accountNumber='" + getAccountNumber() + '\'' +
               ", accountHolder='" + accountHolder + '\'' +
               ", balance=" + balance +
               '}';
  }

  public ArrayList<Transaction> getAllTransactions() {
    return allTransactions;
  }

}