package io.bigtreelab.rndbox.api.advice.exception;

public class CUserCellphoneExitsException extends RuntimeException {
    public CUserCellphoneExitsException() {
        super();
    }

    public CUserCellphoneExitsException(String message) {
        super(message);
    }

    public CUserCellphoneExitsException(String message, Throwable cause) {
        super(message, cause);
    }
}
