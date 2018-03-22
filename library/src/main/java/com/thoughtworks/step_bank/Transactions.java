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
}
