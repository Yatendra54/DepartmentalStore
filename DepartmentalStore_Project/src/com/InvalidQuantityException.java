package com;

public class InvalidQuantityException extends RuntimeException {
	
	private String message;
	
	public InvalidQuantityException(String message)
	{
		this.message=message;
	}
	
	@Override
	public String getMessage()
	{
		return message;
	}
	

}
