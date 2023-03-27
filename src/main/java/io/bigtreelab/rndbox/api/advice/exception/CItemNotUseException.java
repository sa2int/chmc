package io.bigtreelab.rndbox.api.advice.exception;

public class CItemNotUseException extends RuntimeException {

    public CItemNotUseException(String message, Throwable cause) {
        super(message, cause);
    }

    public CItemNotUseException(String message) {
        super(message);
    }

    public CItemNotUseException() {
        super();
    }
}