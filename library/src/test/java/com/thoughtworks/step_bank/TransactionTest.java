package com.thoughtworks.step_bank;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransactionTest {
  @Test
  public void shouldRecordCorrectTransactionDate() {
    Date date = new Date();
    Transaction transaction = new DebitTransaction(date, "ohmcar", 190);
    assertThat(transaction.getDate(),is(date));
  }
}
