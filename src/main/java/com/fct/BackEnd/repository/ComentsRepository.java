package com.fct.BackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fct.BackEnd.entities.Comments;

@Repository
public interface ComentsRepository extends JpaRepository<Comments, Long> {

}
