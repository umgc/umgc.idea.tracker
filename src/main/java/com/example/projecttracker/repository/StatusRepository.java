package com.example.projecttracker.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.example.projecttracker.model.Status;
import com.example.projecttracker.dto.StatusProjectResponse;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long>{

	@Query(value = "SELECT new com.example.projecttracker.dto.StatusProjectResponse(c.status_descr , p.project_title) FROM Status c JOIN c.projects p", nativeQuery = true)
	public List<StatusProjectResponse> getJoinInformation();
	
	
}