package com.sunny.userservice.controller;

import com.sunny.userservice.dto.AuthRequest;
import com.sunny.userservice.dto.AuthResponse;
import com.sunny.userservice.utility.JwtUtil;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody AuthRequest request) {

        // hardcoded credentials
        if ("sunny".equals(request.getUsername())
                && "1234".equals(request.getPassword())) {

            String token =
                    jwtUtil.generateToken(
                            request.getUsername());

            AuthResponse authResponse = new AuthResponse(token);

         //  Wrap it in ResponseEntity and return
         return ResponseEntity.ok(authResponse);
            
        }

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body("Invalid username or password");
    }
}