package com.thoughtworks.step_bank;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

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

  public ArrayList<Transaction> getDebitTransactions() {
    Transactions filteredTransactions = new Transactions();
    for (Transaction transaction:allTransaction){
      if (transaction instanceof DebitTransaction) {
        filteredTransactions.allTransaction.add(transaction);
      }
    }
    return filteredTransactions.allTransaction;
  }

  public ArrayList<Transaction> getCreditTransactions() {
    Transactions filteredTransactions = new Transactions();
    for (Transaction transaction:allTransaction){
      if (transaction instanceof CreditTransaction) {
        filteredTransactions.allTransaction.add(transaction);
      }
    }
    return filteredTransactions.allTransaction;
  }

  public ArrayList<Transaction> filterDebitByAmountGreaterThan(int amount) {
    Transactions filteredTransactions = new Transactions();
    for (Transaction transaction:getDebitTransactions()){
      if (transaction.getAmount()>=amount){
        filteredTransactions.allTransaction.add(transaction);
      }
    }
    return filteredTransactions.allTransaction;
  }

  public ArrayList<Transaction> filterDebitByAmountLessThan(int amount) {
    Transactions filteredTransactions = new Transactions();
    for (Transaction transaction:getDebitTransactions()){
      if (transaction.getAmount()<=amount){
        filteredTransactions.allTransaction.add(transaction);
      }
    }
    return filteredTransactions.allTransaction;
  }

  public void print(FileWriter writer) throws IOException {
    writer.write("date,amount,source\n");
    for (Transaction transaction: allTransaction) {
      writer.write(toCSV(transaction));
    }
  }

    public String toCSV(Transaction transaction) {
    Date date = transaction.getDate();
    Double amount = transaction.getAmount();
    String source = transaction.getSource();
    return date+","+amount+","+source+"\n";
  }
}
