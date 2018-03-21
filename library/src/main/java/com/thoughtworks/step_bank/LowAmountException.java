package com.thoughtworks.step_bank;

public class LowAmountException extends Throwable {
    public LowAmountException() {
        super("Can't credit amount");
    }
}
