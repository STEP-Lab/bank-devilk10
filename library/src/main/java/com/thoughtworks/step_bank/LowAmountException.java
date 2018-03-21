package com.thoughtworks.step_bank;

public class LowAmountException extends Throwable {
    public LowAmountException(String message) {
        super(message);
    }
}