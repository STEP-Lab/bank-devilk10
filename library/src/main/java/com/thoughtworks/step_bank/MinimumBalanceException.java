package com.thoughtworks.step_bank;

public class MinimumBalanceException extends Throwable {
    public MinimumBalanceException() {
        super("minimum balance must be 100");
    }
}
