package com.fct.BackEnd.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fct.BackEnd.entities.Admin;

@Repository
public interface AdminRepository extends MongoRepository<Admin , Long>{

}
