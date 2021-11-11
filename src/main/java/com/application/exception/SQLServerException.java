package com.application.exception;


public class SQLServerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SQLServerException(String msg){
		super(msg);
	}

}
