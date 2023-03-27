package io.bigtreelab.rndbox.api.advice.exception;

public class CUserInventoryNotProcessException extends RuntimeException {
    public CUserInventoryNotProcessException() {
        super();
    }

    public CUserInventoryNotProcessException(String message) {
        super(message);
    }

    public CUserInventoryNotProcessException(String message, Throwable cause) {
        super(message, cause);
    }
}