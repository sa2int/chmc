package io.bigtreelab.rndbox.api.advice.exception;

public class CWechatPayOrderCancelException extends RuntimeException {
    public CWechatPayOrderCancelException() {
        super();
    }

    public CWechatPayOrderCancelException(String message) {
        super(message);
    }

    public CWechatPayOrderCancelException(String message, Throwable cause) {
        super(message, cause);
    }
}