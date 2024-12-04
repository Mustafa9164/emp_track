package com.jsp.app.emp_track.exception;

public class InvalidCredential extends RuntimeException {

	private String message;

	public InvalidCredential(String message) {
		super();
		this.message = message;
	}
	
	public InvalidCredential( ) {
		
	}
	
	@Override
	public String toString() {
		return this.message;
	}
	
	
}
