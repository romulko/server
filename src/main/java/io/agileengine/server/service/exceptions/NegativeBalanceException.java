package io.agileengine.server.service.exceptions;

public class NegativeBalanceException extends RuntimeException {
    public NegativeBalanceException() {
        super("You have no enough amount of money to make this transaction");
    }
}
