package io.bigtreelab.rndbox.api.advice.exception;


public class CUserIdSignupFailedException extends RuntimeException {
    public CUserIdSignupFailedException(String msg, Throwable t) {
        super(msg, t);
    }

    public CUserIdSignupFailedException(String msg) {
        super(msg);
    }

    public CUserIdSignupFailedException() {
        super();
    }
}
