package io.bigtreelab.rndbox.api.advice.exception;

public class CBanException extends RuntimeException {
    public CBanException(String msg, Throwable t) {
        super(msg, t);
    }

    public CBanException(String msg) {
        super(msg);
    }

    public CBanException() {
        super();
    }
}
