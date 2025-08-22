package com.julianoseus.demo_park_api.exception;

public class UsernameUniqueValidationException extends RuntimeException {

    public UsernameUniqueValidationException(String message) {
        super(message);
    }

}
