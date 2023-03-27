package io.bigtreelab.rndbox.api.advice.exception;

public class CUserGiftExistsException extends RuntimeException {
    public CUserGiftExistsException() {
    }

    public CUserGiftExistsException(String message) {
        super(message);
    }

    public CUserGiftExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}