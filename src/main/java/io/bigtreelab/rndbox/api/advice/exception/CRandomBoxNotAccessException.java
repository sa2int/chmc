package io.bigtreelab.rndbox.api.advice.exception;

public class CRandomBoxNotAccessException extends RuntimeException {

	public CRandomBoxNotAccessException(String message, Throwable cause) {
		super(message, cause);
	}

	public CRandomBoxNotAccessException(String message) {
		super(message);
	}

	public CRandomBoxNotAccessException() {
		super();
	}

}
