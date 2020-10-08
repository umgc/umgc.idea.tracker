package edu.umgc.CaPPMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.umgc.CaPPMS.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

}