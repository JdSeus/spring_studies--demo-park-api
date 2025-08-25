package com.julianoseus.demo_park_api.web.exception;

public class CodigoUniqueViolationException extends RuntimeException {

    public CodigoUniqueViolationException(String message) {
        super(message);
    }

}
