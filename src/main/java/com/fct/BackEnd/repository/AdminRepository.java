package com.fct.BackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fct.BackEnd.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin , Long>{

}
