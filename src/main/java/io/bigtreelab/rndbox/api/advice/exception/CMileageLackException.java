package io.bigtreelab.rndbox.api.advice.exception;

public class CMileageLackException extends RuntimeException {

	public CMileageLackException(String message, Throwable cause) {
		super(message, cause);
	}

	public CMileageLackException(String message) {
		super(message);
	}

	public CMileageLackException() {
		super();
	}
}
