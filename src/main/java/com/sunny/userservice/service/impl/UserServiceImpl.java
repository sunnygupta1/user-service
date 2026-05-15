package com.sunny.userservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunny.userservice.dto.UserRequest;
import com.sunny.userservice.entity.User;
import com.sunny.userservice.exception.UserNotFoundException;
import com.sunny.userservice.repository.UserRepository;
import com.sunny.userservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(UserRequest request) {

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        return userRepository.save(user);
    }

	@Override
	public List<User> getAllUsers() {
	
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		
		return userRepository.findById(id)
				.orElseThrow(()-> 
				new UserNotFoundException("user not found " + id)); 
		       //this line mean we r just telling kuch exception hua hai.
		
	}

}
