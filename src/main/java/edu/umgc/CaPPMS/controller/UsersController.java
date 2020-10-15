package edu.umgc.CaPPMS.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.umgc.CaPPMS.exception.ResourceNotFoundException;
import edu.umgc.CaPPMS.model.Users;
import edu.umgc.CaPPMS.repository.UsersRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cappms")
public class UsersController {
	
	@Autowired
	private UsersRepository usersRepository;
	
	
	//get all user
	@GetMapping("/users")
	public List<Users> getAllProject(){
		
		return usersRepository.findAll();
	}
	//create Project
	@PostMapping("/users")
	public Users createProject(@RequestBody Users users) {
		return usersRepository.save(users);
	}
	//get user by id
	@GetMapping("/users/{id}")
	public ResponseEntity<Users> getProjectById(@PathVariable Long id) {
		
		Users  users = usersRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id:"+id));
		return ResponseEntity.ok(users);
		
	}
	//Update user
	@PutMapping("/user/{id}")
	public ResponseEntity<Users> updateProject(@PathVariable Long id, @RequestBody Users usersDetails){
		Users users = usersRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
		
		users.setFirst_name(usersDetails.getFirst_name());
		users.setLast_name(usersDetails.getLast_name());
		users.setPhone_number(usersDetails.getPhone_number());
		users.setEmail(usersDetails.getEmail());
		//users.setUser_type(usersDetails.getUser_type());
		users.setTitle(usersDetails.getTitle());
		users.setWebsite(usersDetails.getWebsite());
		users.setEmpl_id(usersDetails.getEmpl_id());
		
		
		
		Users updatedUsers = usersRepository.save(users);
		return ResponseEntity.ok(updatedUsers);
	}
	
	// delete user
	@DeleteMapping("/users/{id}")
	public ResponseEntity <Map<String, Boolean>> deleteProject(@PathVariable Long id){
		Users users = usersRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
		usersRepository.delete(users);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
				
	}
	
}
