package edu.umgc.CaPPMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.umgc.CaPPMS.model.Usr_Type;

@Repository
public interface Usr_TypeRepository extends JpaRepository<Usr_Type, Long>{

}