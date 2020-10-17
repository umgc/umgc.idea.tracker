package com.example.projecttracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projecttracker.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

}
