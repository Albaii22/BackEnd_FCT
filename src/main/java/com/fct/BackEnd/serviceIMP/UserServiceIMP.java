package com.fct.BackEnd.serviceIMP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fct.BackEnd.entities.User;
import com.fct.BackEnd.repository.UserRepository;
import com.fct.BackEnd.services.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceIMP implements UserService {

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
        user.setId(id);
        return userRepository.save(user);
    }

    public void deleteUsuario(Long id) {
        userRepository.deleteById(id);
    }
}
