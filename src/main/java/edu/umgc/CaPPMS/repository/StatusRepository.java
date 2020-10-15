


package edu.umgc.CaPPMS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import edu.umgc.CaPPMS.model.Status;
import edu.umgc.CaPPMS.dto.StatusProjectResponse;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long>{

	@Query("SELECT new com.example.projecttracker.dto.StatusProjectResponse(c.status_descr , p.project_title) FROM Status c JOIN c.projects p")
	public List<StatusProjectResponse> getJoinInformation();
	
	
}