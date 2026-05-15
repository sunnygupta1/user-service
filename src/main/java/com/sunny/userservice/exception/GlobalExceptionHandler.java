package com.sunny.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sunny.userservice.dto.ErrorResponse;


//its globle exception handler for all controller instead of writing try catch block
//ye automaticaly detect kr leta hai any exception hua in controller me to
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)// spring check krta rhta hai ki khi pure app me ye class wala exception to throw nhi ho rha hai ..
	public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex){
		
		//yha we r  creating obj of errorResponse class so that we can send customized response in body.
		ErrorResponse error = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
		
		//here we r returning body
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}

}
