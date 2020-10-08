package edu.umgc.CaPPMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.umgc.CaPPMS.model.Project;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

}