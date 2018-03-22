package com.thoughtworks.step_bank;

import java.util.Date;

public class CreditTransaction extends Transaction {
  protected CreditTransaction(Date date, String to, double amount) {
    super(date,to,amount);
  }

  public CreditTransaction(String to, double amount) {
    this(new Date(),to,amount);
  }
}
