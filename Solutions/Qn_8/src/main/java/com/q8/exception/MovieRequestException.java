package com.q8.exception;

public class MovieRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MovieRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	public MovieRequestException(String message) {
		super(message);
	}
}
