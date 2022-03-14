package com.q8.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class MovieExceptionHandler {
	
	@ExceptionHandler(value= {MovieRequestException.class})
	public ResponseEntity<Object> handleProfileRequestException(MovieRequestException e){
		
		HttpStatus badRequest=HttpStatus.BAD_REQUEST;
	    MovieException apiException=new MovieException(e.getMessage());
		return new ResponseEntity<Object>(apiException,badRequest);
	}

}
