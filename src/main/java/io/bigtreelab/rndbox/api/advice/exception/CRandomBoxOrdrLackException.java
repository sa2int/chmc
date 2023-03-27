package io.bigtreelab.rndbox.api.advice.exception;

public class CRandomBoxOrdrLackException extends RuntimeException {

    public CRandomBoxOrdrLackException(String message, Throwable cause) {
        super(message, cause);
    }

    public CRandomBoxOrdrLackException(String message) {
        super(message);
    }

    public CRandomBoxOrdrLackException() {
        super();
    }
}