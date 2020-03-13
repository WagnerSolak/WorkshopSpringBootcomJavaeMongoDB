package com.solak.workshopmongo.services.exception;


public class ObjectNotFoundException extends RuntimeException{


	private static final long serialVersionUID = 1L;
	
	//sobrepor o método
	public ObjectNotFoundException(String msg) {
		super(msg);
	}

}
