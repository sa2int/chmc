package io.bigtreelab.rndbox.api.advice.exception;

public class CEventAttendanceExistsException extends RuntimeException {
    public CEventAttendanceExistsException() {
    }

    public CEventAttendanceExistsException(String message) {
        super(message);
    }

    public CEventAttendanceExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}