package com.fct.BackEnd.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fct.BackEnd.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long>{

    Object findByUsername(String username);

}
