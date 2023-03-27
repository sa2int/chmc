package io.bigtreelab.rndbox.api.advice.exception;

public class CUserGiftNoExistsException extends RuntimeException {
    public CUserGiftNoExistsException() {
    }

    public CUserGiftNoExistsException(String message) {
        super(message);
    }

    public CUserGiftNoExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}