package com.sunny.userservice.exception;

public class UserNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	//here we r just creating construstor of this class and extending runTime Exception
	public UserNotFoundException(String msg) {
		super(msg);
	}
	

}
