package com.application.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BadRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ExceptionType type;
	
	public BadRequestException(String msg) {
		super(msg);
	}
	
	public BadRequestException(String msg, ExceptionType type) {
		super(msg);
		this.setType(type);
	}

}
