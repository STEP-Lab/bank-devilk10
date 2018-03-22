package com.thoughtworks.step_bank;

import org.junit.Test;

public class AccountNumberTest {
  @Test
  public void checkAccountNumber() throws InvalidAccountNumberException {
    new AccountNumber("1121-2312");
  }

  @Test (expected = InvalidAccountNumberException.class)
  public void checkAccountNumberException() throws InvalidAccountNumberException {
    new AccountNumber("1111-22");
  }
}
