package com.fct.BackEnd.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fct.BackEnd.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long>{

    Optional<User> findByUsername(String username);

}
