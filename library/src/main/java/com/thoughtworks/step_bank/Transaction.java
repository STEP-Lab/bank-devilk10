package com.thoughtworks.step_bank;

import java.util.Date;
import java.util.Objects;

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

  public String getTo() {
    return to;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Transaction that = (Transaction) o;
    return Double.compare(that.amount, amount) == 0 &&
               Objects.equals(to, that.to);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, to);
  }

  public double getAmount() {
    return amount;
  }

  @Override
  public String toString() {
    return "Transaction{" +
               "amount=" + amount +
               ", date=" + date +
               ", to='" + to + '\'' +
               '}';
  }
}
