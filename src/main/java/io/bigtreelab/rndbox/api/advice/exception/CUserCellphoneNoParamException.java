package io.bigtreelab.rndbox.api.advice.exception;

public class CUserCellphoneNoParamException extends RuntimeException {
    public CUserCellphoneNoParamException() {
        super();
    }

    public CUserCellphoneNoParamException(String message) {
        super(message);
    }

    public CUserCellphoneNoParamException(String message, Throwable cause) {
        super(message, cause);
    }
}