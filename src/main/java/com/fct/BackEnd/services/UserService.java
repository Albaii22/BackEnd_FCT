package com.fct.BackEnd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fct.BackEnd.entities.User;
import com.fct.BackEnd.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsuarios() {
        return userRepository.findAll();
    }

    public Optional<User> getUsuarioById(Long id) {
        return userRepository.findById(id);
    }

    public User createUsuario(User user) {
        return userRepository.save(user);
    }

    public User updateUsuario(Long id, User user) {
        user.set_id(id);
        return userRepository.save(user);
    }

    public void deleteUsuario(Long id) {
        userRepository.deleteById(id);
    }
}
