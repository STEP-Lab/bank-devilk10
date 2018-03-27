package com.thoughtworks.step_bank;

import java.util.ArrayList;

public class Transactions {
  protected final ArrayList<Transaction> allTransaction;

  public Transactions() {
    this.allTransaction = new ArrayList<>();
  }

  public void debit(String to, double amount) {
    this.allTransaction.add(new DebitTransaction(to,amount));
  }

  public void credit(String to, double amount) {
    this.allTransaction.add(new CreditTransaction(to,amount));
  }

  public ArrayList<Transaction> filterByAmountGreaterThan(int amount) {
    Transactions filteredTransactions = new Transactions();
    for (Transaction transaction:allTransaction){
      if (transaction.getAmount()>=amount){
        filteredTransactions.allTransaction.add(transaction);
      }
    }
    return filteredTransactions.allTransaction;
    }
}
