package io.bigtreelab.rndbox.api.advice.exception;

public class CRandomBoxNotOrderException extends RuntimeException {

    public CRandomBoxNotOrderException(String message, Throwable cause) {
        super(message, cause);
    }

    public CRandomBoxNotOrderException(String message) {
        super(message);
    }

    public CRandomBoxNotOrderException() {
        super();
    }
}