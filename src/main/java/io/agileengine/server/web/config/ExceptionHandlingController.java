package io.agileengine.server.web.config;

import io.agileengine.server.service.exceptions.NegativeBalanceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NegativeBalanceException.class)
    public ResponseEntity<Error> handleNegativeBalanceException(NegativeBalanceException e) {
        return new ResponseEntity<>(new Error(e.getMessage()), HttpStatus.CONFLICT);
    }

    private static class Error {
        private final String error;

        public Error(String error) {
            this.error = error;
        }

        public String getError() {
            return error;
        }
    }
}
