package com.alex.spring.boot.theraventest.exceptionHanding;

public class NoSuchCustomerException extends RuntimeException {
    public NoSuchCustomerException(String message) {
        super(message);
    }
}
