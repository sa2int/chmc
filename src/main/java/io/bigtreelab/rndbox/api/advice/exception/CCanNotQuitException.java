package io.bigtreelab.rndbox.api.advice.exception;

public class CCanNotQuitException extends RuntimeException {
    public CCanNotQuitException() {
        super();
    }

    public CCanNotQuitException(String message) {
        super(message);
    }

    public CCanNotQuitException(String message, Throwable cause) {
        super(message, cause);
    }
}
