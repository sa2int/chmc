package io.bigtreelab.rndbox.api.advice.exception;

public class CProductProcessStatusException extends RuntimeException {
    public CProductProcessStatusException() {
        super();
    }

    public CProductProcessStatusException(String message) {
        super(message);
    }

    public CProductProcessStatusException(String message, Throwable cause) {
        super(message, cause);
    }

}
