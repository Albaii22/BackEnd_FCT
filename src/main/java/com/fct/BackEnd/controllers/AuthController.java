package com.fct.BackEnd.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fct.BackEnd.requests.AuthResponse;
import com.fct.BackEnd.requests.LoginRequest;
import com.fct.BackEnd.requests.RegisterRequest;
import com.fct.BackEnd.jwt.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
     
    @CrossOrigin
    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){

        return ResponseEntity.ok(authService.login(request));
    }

    @CrossOrigin
    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> login(@RequestBody RegisterRequest request){
        
        return ResponseEntity.ok(authService.register(request));
    }
}
