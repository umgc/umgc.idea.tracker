package com.example.projecttracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.projecttracker.model.Account;
import com.example.projecttracker.model.Status;
import com.example.projecttracker.model.User;
import com.example.projecttracker.model.Usr_Type;
import com.example.projecttracker.repository.AccountRepository;
import com.example.projecttracker.repository.StatusRepository;
import com.example.projecttracker.repository.UserRepository;
import com.example.projecttracker.repository.Usr_TypeRepository;

@Component
public class DBInitializer implements ApplicationRunner {
	
	private StatusRepository statusRepository;
	private AccountRepository accountRepository;
	private Usr_TypeRepository userTypeRepository;
	private UserRepository userRepository;
	
	@Autowired
	public DBInitializer(StatusRepository statusRepo, AccountRepository accoutRepo, Usr_TypeRepository userTypeRepo , UserRepository userRepo)
	{
		this.statusRepository = statusRepo;
		this.accountRepository = accoutRepo;
		this.userTypeRepository = userTypeRepo;
		this.userRepository = userRepo;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception 
	{
		
		if(statusRepository.count() == 0)
		{
			statusRepository.save(new Status("PENDING"));
			statusRepository.save(new Status("APPROVED"));
			statusRepository.save(new Status("REJECTED"));
		}
		if(userTypeRepository.count()==0)
		{
			userTypeRepository.save(new Usr_Type(1, "SPONSOR"));
			userTypeRepository.save(new Usr_Type(2, "LIASION"));
			userTypeRepository.save(new Usr_Type(3, "OTHER"));

		}
		if(userRepository.count() == 0)
		{
			userRepository.save(new User("Professor", "Admin", "", "", 1, "", "", ""));
		}
		if(accountRepository.count() == 0)
		{
			accountRepository.save(new Account("professoradmin", new BCryptPasswordEncoder().encode("professorpassword"), true, 1));
		}

	}
	 

}
