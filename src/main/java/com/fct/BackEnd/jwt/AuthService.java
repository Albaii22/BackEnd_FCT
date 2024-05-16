package com.fct.BackEnd.jwt;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fct.BackEnd.entities.Role;
import com.fct.BackEnd.entities.User;
import com.fct.BackEnd.repository.UserRepository;
import com.fct.BackEnd.requests.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final jwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager; //autenticar al usuario

    @CrossOrigin
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));//Recibe credenciales
        UserDetails user = (UserDetails) userRepository.findByUsername(request.getUsername()); //generamos token
        String token = jwtService.getToken((User) user);
        return AuthResponse.builder() //Generamos la respuesta con el token ya generado
            .token(token)
            .build();
    }

    @CrossOrigin
    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode(request.getPassword()))
            .email(request.getEmail())
            .registration_date(request.getRegistration_date())
            .role(Role.USER)
            .build();

        userRepository.save(user); //Se guarda el objeto en la base de datos 

        return AuthResponse.builder() //Se obtiene el token a traves del lservidode de jwt que se retorna al controlador y luego al cleinte
            .token(jwtService.getToken(user))
            .build();
    }

}