package io.bigtreelab.rndbox.api.advice.exception;

public class CCouponPriceException extends RuntimeException {
    public CCouponPriceException() {
        super();
    }

    public CCouponPriceException(String message) {
        super(message);
    }

    public CCouponPriceException(String message, Throwable cause) {
        super(message, cause);
    }
}