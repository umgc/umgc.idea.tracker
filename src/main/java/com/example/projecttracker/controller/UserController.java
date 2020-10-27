package com.example.projecttracker.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projecttracker.exception.ResourceNotFoundException;
import com.example.projecttracker.model.Account;
import com.example.projecttracker.model.User;
import com.example.projecttracker.repository.AccountRepository;
import com.example.projecttracker.repository.UserRepository;
import com.example.projecttracker.security.AuthenticationBean;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private DataSource dataSource;
	 
	
	//get all user
	@GetMapping("/user")
	public List<User> getAllUser(){
		
		return userRepository.findAll();
	}
	//create Project
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		
		return userRepository.save(user);
	}
	//get user by id
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		
		User  user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id:"+id));
		return ResponseEntity.ok(user);
		
	}
	//Update user
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails){
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
		
		user.setFirst_name(userDetails.getFirst_name());
		user.setLast_name(userDetails.getLast_name());
		user.setPhone_number(userDetails.getPhone_number());
		user.setEmail(userDetails.getEmail());
//		user.setUsr_type(userDetails.getUser_type());
		user.setTitle(userDetails.getTitle());
//		user.setUsr_type(userDetails.getUser().getUsr_type());
		
		
		
		
		User updatedUser = userRepository.save(user);
		return ResponseEntity.ok(updatedUser);
	}
	
	// delete user
	@DeleteMapping("/user/{id}")
	public ResponseEntity <Map<String, Boolean>> deleteUser(@PathVariable Long id){
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
		userRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
				
	}
	
	
    @GetMapping(path = "/basicauth")
    public AuthenticationBean basicauth() {
        return new AuthenticationBean("You are authenticated");
    }

    
    @PostMapping(path = "/createaccount")
    public Account createAccount(@RequestBody Account account)
    {
    	account.setPassword(new BCryptPasswordEncoder().encode(account.getPassword()));
    	return accountRepository.save(account);
    }

}

