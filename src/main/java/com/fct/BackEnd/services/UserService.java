package com.fct.BackEnd.services;

import com.fct.BackEnd.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsuarios();
    Optional<User> getUsuarioById(Long id);
    User createUsuario(User user);
    User updateUsuario(Long id, User user);
    void deleteUsuario(Long id);
}
