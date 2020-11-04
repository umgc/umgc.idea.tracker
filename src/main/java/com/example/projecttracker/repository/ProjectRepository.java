package com.example.projecttracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projecttracker.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

}
