package com.sunny.userservice.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.sunny.userservice.dto.UserRequest;
import com.sunny.userservice.entity.User;

public interface UserService {
	
	public User createUser(UserRequest request);
	
	public List<User> getAllUsers();
	
	public User getUserById(Long Id);
	
	//for implementing pagination
	Page<User> getUsersWithPagination(
            int page,
            int size);

}
