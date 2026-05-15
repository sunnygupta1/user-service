package com.sunny.userservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequest {

    @NotBlank
    private String name;

    @Email
    private String email;

    @NotBlank
    private String password;
}

//as u r seeing it have same variable name as entity so keep remember dto r used to map the request with http request 
//and entity are used to communicate with jpa repository.
