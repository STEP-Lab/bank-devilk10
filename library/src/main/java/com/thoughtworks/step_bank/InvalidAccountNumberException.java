package com.thoughtworks.step_bank;

public class InvalidAccountNumberException extends Throwable {
    public InvalidAccountNumberException() {
        super("Account number pattern didn't match");
    }
}
