package com.application.exception;


public class SqlExceptionHelper extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SqlExceptionHelper(String msg){
		super(msg);
	}

}
