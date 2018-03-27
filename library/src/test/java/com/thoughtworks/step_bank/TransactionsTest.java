package com.thoughtworks.step_bank;

import org.junit.Before;
import org.junit.Test;

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
}
