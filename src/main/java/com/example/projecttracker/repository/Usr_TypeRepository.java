package com.example.projecttracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projecttracker.model.Usr_Type;

@Repository
public interface Usr_TypeRepository extends JpaRepository<Usr_Type, Long>{

}