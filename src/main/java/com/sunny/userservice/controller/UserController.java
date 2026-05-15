package com.sunny.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.userservice.dto.UserRequest;
import com.sunny.userservice.entity.User;
import com.sunny.userservice.service.UserService;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
	
	
	private final UserService userService;
	
	@PostMapping("/createuser")
	public ResponseEntity<User> createUser(@Valid @RequestBody UserRequest request) {
		User user = userService.createUser(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
		
	}
	
	@GetMapping("/getalluser")
	public List<User> getalluser(){
		return userService.getAllUsers();
	}
	
	@GetMapping("getuserbyid")
	public ResponseEntity<User> getUserById(@RequestParam Long id) {
		User user = userService.getUserById(id);
		return ResponseEntity.ok(user);
	}

}
