package com.example.projecttracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projecttracker.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
