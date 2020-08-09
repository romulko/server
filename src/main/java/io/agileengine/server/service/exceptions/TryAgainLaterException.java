package io.agileengine.server.service.exceptions;

public class TryAgainLaterException extends RuntimeException {
    public TryAgainLaterException() {
        super("Try again later");
    }
}
