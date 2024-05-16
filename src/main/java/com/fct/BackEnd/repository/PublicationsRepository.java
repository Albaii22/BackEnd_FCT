package com.fct.BackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fct.BackEnd.entities.Publications;

@Repository
public interface PublicationsRepository extends JpaRepository<Publications, Long>{

}
