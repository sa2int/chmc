package io.bigtreelab.rndbox.api.advice.exception;

public class CWechatUserExistException extends RuntimeException {
    public CWechatUserExistException() {
        super();
    }

    public CWechatUserExistException(String message) {
        super(message);
    }

    public CWechatUserExistException(String message, Throwable cause) {
        super(message, cause);
    }
}