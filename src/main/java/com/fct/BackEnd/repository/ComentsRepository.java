package com.fct.BackEnd.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fct.BackEnd.entities.Comments;

@Repository
public interface ComentsRepository extends MongoRepository<Comments, Long> {

}
