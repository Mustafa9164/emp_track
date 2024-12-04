package com.jsp.app.emp_track.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(InvalidCredential.class)
	public ResponseEntity invaliddata(InvalidCredential ex) {
		return new ResponseEntity("not found",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidOtpException.class)
	public ResponseEntity invalidOtp(InvalidOtpException ex) {
		return new ResponseEntity(ex.getMessage(),HttpStatus.NOT_FOUND);
	}

}
