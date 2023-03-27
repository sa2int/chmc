package io.bigtreelab.rndbox.api.advice.exception;

public class CItemHitLackException extends RuntimeException {

    public CItemHitLackException(String message, Throwable cause) {
        super(message, cause);
    }

    public CItemHitLackException(String message) {
        super(message);
    }

    public CItemHitLackException() {
        super();
    }
}