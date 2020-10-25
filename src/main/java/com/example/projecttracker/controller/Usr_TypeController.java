package com.example.projecttracker.controller;

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

import com.example.projecttracker.dto.StatusProjectRequest;
import com.example.projecttracker.dto.StatusProjectResponse;
import com.example.projecttracker.dto.Usr_TypeUsersRequest;
import com.example.projecttracker.dto.Usr_TypeUsersResponse;

import com.example.projecttracker.exception.ResourceNotFoundException;
import com.example.projecttracker.model.Status;
import com.example.projecttracker.model.Usr_Type;
import com.example.projecttracker.repository.UserRepository;
import com.example.projecttracker.repository.Usr_TypeRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cappms")
public class Usr_TypeController {
	
	@Autowired
	private Usr_TypeRepository usr_typeRepository;
	
	@Autowired
    private UserRepository usersRepository;
	
	//get all user_Types
	@GetMapping("/usr_type")
	public List<Usr_Type> getAllUsr_Type(){
		
		return usr_typeRepository.findAll();
	}
	//create Usr_Type
	@PostMapping("/usr_type")
	public Usr_Type createUsr_Type(@RequestBody Usr_Type usr_type) {
		return usr_typeRepository.save(usr_type);
	}
	//get usr_type by id
	@GetMapping("/usr_type/{id}")
	public ResponseEntity<Usr_Type> getUsr_TypeById(@PathVariable Long id) {
		
		Usr_Type  usr_type = usr_typeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Usr_Type not exist with id:"+id));
		return ResponseEntity.ok(usr_type);
		
	}
	//Update usr_type
	@PutMapping("/usr_type/{id}")
	public ResponseEntity<Usr_Type> updateUsr_Type(@PathVariable Long id, @RequestBody Usr_Type usr_typeDetails){
		Usr_Type usr_type = usr_typeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Usr_Type not exist with id :" + id));
		
		usr_type.setUtype_descr(usr_typeDetails.getUtype_descr());
		
		
		Usr_Type updatedUsr_Type = usr_typeRepository.save(usr_type);
		return ResponseEntity.ok(updatedUsr_Type);
	}
	
	// delete usr_type
	@DeleteMapping("/usr_type/{id}")
	public ResponseEntity <Map<String, Boolean>> deleteUsr_Type(@PathVariable Long id){
		Usr_Type usr_type = usr_typeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Usr_Type not exist with id :" + id));
		usr_typeRepository.delete(usr_type);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
				
	}
	
	@PostMapping("/submitUsersWithTypes")
    public Usr_Type placeOrder(@RequestBody Usr_TypeUsersRequest request){
       return usr_typeRepository.save(request.getUsr_type());
    }

    @GetMapping("/findUsersWithTypes")
    public List<Usr_Type> findAllOrders(){
        return usr_typeRepository.findAll();
    }

//    @GetMapping("/getUsersWithTypes")
//    public List<Usr_TypeUsersResponse> getJoinInformation(){
//        return usr_typeRepository.getJoinInformation();
//    }
}
