package io.bigtreelab.rndbox.api.advice.exception;

public class CShippingUserInventoryLackException extends RuntimeException {

	public CShippingUserInventoryLackException(String message, Throwable cause) {
		super(message, cause);
	}

	public CShippingUserInventoryLackException(String message) {
		super(message);
	}

	public CShippingUserInventoryLackException() {
		super();
	}
}
