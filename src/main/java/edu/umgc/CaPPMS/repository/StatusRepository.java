package edu.umgc.CaPPMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.umgc.CaPPMS.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long>{

}