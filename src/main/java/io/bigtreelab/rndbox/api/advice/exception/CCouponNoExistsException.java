package io.bigtreelab.rndbox.api.advice.exception;

public class CCouponNoExistsException extends RuntimeException {
    public CCouponNoExistsException() {
        super();
    }

    public CCouponNoExistsException(String message) {
        super(message);
    }

    public CCouponNoExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}