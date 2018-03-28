package com.thoughtworks.step_bank;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertThat;

public class TransactionsTest {
  Transactions transaction;
  @Before
  public void setUp() {
    transaction = new Transactions();
  }

  @Test
  public void shouldAddDebitTransaction() {
    transaction.debit("Harshad",1000);
    assertThat(transaction.allTransaction,hasItem(new DebitTransaction("Harshad",1000)));
  }

  @Test
  public void shouldAddCreditTransaction() {
    transaction.credit("Harshad",1000);
    assertThat(transaction.allTransaction,hasItem(new CreditTransaction("Harshad",1000)));

  }

  @Test
  public void shouldAddBothTransactions() {
    transaction.credit("Harshad",1000);
    transaction.debit("Harshad",1000);
    assertThat(transaction.allTransaction,hasItem(new CreditTransaction("Harshad",1000)));
    assertThat(transaction.allTransaction,hasItem(new DebitTransaction("Harshad",1000)));
  }

  @Test
  public void filterTransactionByAmount() {
    transaction.credit("Pallabi", 1000);
    transaction.credit("Pallabi", 1200);
    transaction.credit("Pallabi", 900);
    ArrayList<Transaction> trans = transaction.filterByAmountGreaterThan(1100);
    assertThat(trans,hasItem(new CreditTransaction("Pallabi",1200)));
  }

  @Test
  public void filterDebitTransactionByAmount() {
    transaction.debit("Pallabi", 1200);
    transaction.debit("Pallabi", 900);
    ArrayList<Transaction> trans = transaction.filterDebitByAmountGreaterThan(1100);
    assertThat(trans,hasItem(new DebitTransaction("Pallabi",1200)));
  }

  @Test
  public void filterDebitTransactionByAmountLessThan() {
    transaction.debit("Pallabi", 1200);
    transaction.debit("Pallabi", 900);
    ArrayList<Transaction> trans = transaction.filterDebitByAmountLessThan(1100);
    assertThat(trans,hasItem(new DebitTransaction("Pallabi",900)));
  }

  @Test
  public void shouldReturnAllDebitTransactions() {
    transaction.debit("Pallabi", 900);
    ArrayList<Transaction> trans = transaction.getDebitTransactions();
    assertThat(trans,hasItem(new DebitTransaction("Pallabi",900)));
  }

  @Test
  public void shouldGetAllCreditTransactions() {
    transaction.credit("ketan",1000);
    ArrayList<Transaction> trans = transaction.getCreditTransactions();
    assertThat(trans,hasItem(new CreditTransaction("ketan",1000)));
  }

  @Test
  public void shouldAddTransactionsToFile() throws IOException {
    ArrayList<String> result=new ArrayList<>();
    transaction.credit("ketan",1000);
    transaction.debit("pallabi",1200);
    File file = new File("transactions.csv");
    FileWriter wr = new FileWriter(file){
      @Override
      public void write(String str) throws IOException {
        result.add(str);
        System.out.println(str);
      }
    };
    transaction.print(wr);
    wr.close();
    Transaction credit = new CreditTransaction("ketan",1000);
    String creditString=transaction.toCSV(credit);
    assertThat(result,hasItem(creditString));
  }
}
