package io.bigtreelab.rndbox.api.advice.exception;

public class CProductPriceException extends RuntimeException {
    public CProductPriceException() {
        super();
    }

    public CProductPriceException(String message) {
        super(message);
    }

    public CProductPriceException(String message, Throwable cause) {
        super(message, cause);
    }
}