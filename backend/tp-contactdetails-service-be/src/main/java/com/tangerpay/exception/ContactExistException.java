package com.tangerpay.exception;

public class ContactExistException extends RuntimeException {

    public ContactExistException() {
        super();
    }

    public ContactExistException(String exception) {
        super(exception);
    }

}
