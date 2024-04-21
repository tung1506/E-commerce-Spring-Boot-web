package com.springserver.server.exception;

public class InvalidCredentialsException extends RuntimeException{
    public InvalidCredentialsException(String message) {
        super(message);
    }
}
