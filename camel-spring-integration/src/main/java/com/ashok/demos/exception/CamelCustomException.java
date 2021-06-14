package com.ashok.demos.exception;

public class CamelCustomException extends Exception{
	
	public CamelCustomException(String message) {
		super(message);
	}
	
	public CamelCustomException(){
		super();
	}

}
