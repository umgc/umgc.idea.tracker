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
	public Users createProject(@RequestBody Users user) {
		return usersRepository.save(user);
	}
	//get user by id
	@GetMapping("/users/{id}")
	public ResponseEntity<Users> getProjectById(@PathVariable Long id) {
		
		Users  user = usersRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id:"+id));
		return ResponseEntity.ok(user);
		
	}
	//Update user
	@PutMapping("/users/{id}")
	public ResponseEntity<Users> updateProject(@PathVariable Long id, @RequestBody Users userDetails){
		Users user = usersRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
		
		user.setFirst_name(userDetails.getFirst_name());
		user.setLast_name(userDetails.getLast_name());
		user.setPhone_number(userDetails.getPhone_number());
		user.setEmail(userDetails.getEmail());
		user.setUser_type(userDetails.getUser_type());
		user.setTitle(userDetails.getTitle());
		user.setWebsite(userDetails.getWebsite());
		user.setEmpl_id(userDetails.getEmpl_id());
		
		
		
		Users updatedUser = usersRepository.save(user);
		return ResponseEntity.ok(updatedUser);
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
