package com.thoughtworks.step_bank;

public class AccountNumber {
  public final String number;

  AccountNumber(String accountNumber) throws InvalidAccountNumberException{
    this.number=accountNumber;
    if (incorrectAccountNumberPattern()) {
      throw new InvalidAccountNumberException();
    }
  }

  private boolean incorrectAccountNumberPattern() {
    return !number.matches("^\\d{4}-\\d{4}$");
  }

}
