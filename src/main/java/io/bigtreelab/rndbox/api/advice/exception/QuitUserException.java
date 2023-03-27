package io.bigtreelab.rndbox.api.advice.exception;

public class QuitUserException extends RuntimeException {
    public QuitUserException() {
        super();
    }

    public QuitUserException(String message) {
        super(message);
    }

    public QuitUserException(String message, Throwable cause) {
        super(message, cause);
    }
}
