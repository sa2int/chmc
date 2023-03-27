package io.bigtreelab.rndbox.api.advice.exception;

public class CItemShakeLackException extends RuntimeException {

    public CItemShakeLackException(String message, Throwable cause) {
        super(message, cause);
    }

    public CItemShakeLackException(String message) {
        super(message);
    }

    public CItemShakeLackException() {
        super();
    }
}