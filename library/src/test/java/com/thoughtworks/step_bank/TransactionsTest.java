package com.thoughtworks.step_bank;

import org.junit.Test;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertThat;

public class TransactionsTest {
  @Test
  public void shouldAddDebitTransaction() {
    Transactions transaction = new Transactions();
    transaction.debit("Harshad",1000);
    assertThat(transaction.allTransaction,hasItem(new DebitTransaction("Harshad",1000)));
  }
}
