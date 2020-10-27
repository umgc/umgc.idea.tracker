package com.example.projecttracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projecttracker.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>
{

	Account findByUsername(String username);


}
