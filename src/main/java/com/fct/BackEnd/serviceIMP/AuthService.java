package com.fct.BackEnd.serviceIMP;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fct.BackEnd.entities.*;
import com.fct.BackEnd.repository.UserRepository;
import com.fct.BackEnd.requests.AuthResponse;
import com.fct.BackEnd.requests.LoginRequest;
import com.fct.BackEnd.requests.RegisterRequest;
import com.fct.BackEnd.jwt.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final jwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager; 

    @CrossOrigin
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken((User) user);
        return AuthResponse.builder()
            .token(token)
            .build();
    }

    @CrossOrigin
    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode(request.getPassword()))
            .email(request.getEmail())
            .role(Role.USER)
            .build();

        userRepository.save(user);  

        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();
    }

}
