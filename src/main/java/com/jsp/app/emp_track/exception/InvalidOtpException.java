package com.jsp.app.emp_track.exception;

public class InvalidOtpException extends RuntimeException {
	
	private String message="invalid otp";

	public InvalidOtpException(String message) {
		super();
		this.message = message;
	}

	public InvalidOtpException() {
		super();
	}

	@Override
	public String getMessage() {
		return message;
	}
	
	
	
	

}
