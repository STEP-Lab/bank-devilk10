package com.thoughtworks.step_bank;


public class Account {
  private final AccountNumber accountNumber;
  private final String accountHolder;
  private final double minimumBalance = 100;
  private double balance;

  Account(String accountHolder, String accountNumber, double balance) throws InvalidAccountNumberException, LowAmountException {
    if (balance < minimumBalance) {
      throw new LowAmountException("Insufficient account balance to create account");
    }
    this.accountHolder=accountHolder;
    this.accountNumber=new AccountNumber(accountNumber);
    this.balance=balance;
  }

  public String getAccountNumber() {
    return accountNumber.number;
  }

  public double getBalance() {
    return balance;
  }

  public double credit(int amount) throws LowAmountException {
    if (!canCredit(amount)) {
      throw new LowAmountException("Invalid credit request");
    }
    balance += amount;
    return balance;
  }

  public boolean canCredit(int amount) {
    return amount > 0;
  }

  public double debit(int amount) throws LowAmountException {
    if (!canDebit(amount)) {
      throw new LowAmountException("Can't process your debit request due to low balance");
    }
    balance -= amount;
    return balance;
  }

  public boolean canDebit(int amount) {
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
}