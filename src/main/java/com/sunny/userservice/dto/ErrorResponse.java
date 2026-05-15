package com.sunny.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

//used to create getr setr
@Data

//used to create all args constroctor
@AllArgsConstructor
public class ErrorResponse {
	
	private String messege;
	private int status;
	

}
//this is for globle exception handling .. keep remember error are also a type of response.
