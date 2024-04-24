package com.fct.BackEnd.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fct.BackEnd.entities.Coments;

@Repository
public interface ComentsRepository extends MongoRepository<Coments, Long> {

}
