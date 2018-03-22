package com.thoughtworks.step_bank;

import java.util.Date;

public abstract class Transaction {
  private final double amount;
  private final Date date;
  private final String to;

  public Transaction(Date date, String to, double amount) {
    this.date=date;
    this.to=to;
    this.amount=amount;
  }

  public Date getDate() {
    return date;
  }
}
