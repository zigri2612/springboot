package com.rk.testinggo.exception;

public class InvalidEmailException extends Exception {
	private static final long serialVersionUID=1L;
	public InvalidEmailException(String message) {
		super(message);
	}

}
