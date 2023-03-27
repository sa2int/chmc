package io.bigtreelab.rndbox.api.advice.exception;

public class CItemSeeLackException extends RuntimeException {

    public CItemSeeLackException(String message, Throwable cause) {
        super(message, cause);
    }

    public CItemSeeLackException(String message) {
        super(message);
    }

    public CItemSeeLackException() {
        super();
    }
}