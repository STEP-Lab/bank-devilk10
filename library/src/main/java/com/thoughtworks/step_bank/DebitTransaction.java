package com.thoughtworks.step_bank;

import java.util.Date;

public class DebitTransaction extends Transaction {
  protected DebitTransaction(Date date, String to, double amount) {
    super(date,to,amount);
  }

  public DebitTransaction(String to, double amount) {
    this(new Date(),to,amount);
  }
}
