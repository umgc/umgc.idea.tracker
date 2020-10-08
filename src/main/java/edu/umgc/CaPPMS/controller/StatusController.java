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
import edu.umgc.CaPPMS.model.Status;
import edu.umgc.CaPPMS.repository.StatusRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cappms")
public class StatusController {
	
	@Autowired
	private StatusRepository statusRepository;
	
	
	//get all statuses
	@GetMapping("/status")
	public List<Status> getAllStatus(){
		
		return statusRepository.findAll();
	}
	//create Status
	@PostMapping("/status")
	public Status createStatus(@RequestBody Status status) {
		return statusRepository.save(status);
	}
	//get status by id
	@GetMapping("/status/{id}")
	public ResponseEntity<Status> getStatusById(@PathVariable Long id) {
		
		Status  status = statusRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Status not exist with id:"+id));
		return ResponseEntity.ok(status);
		
	}
	//Update status
	@PutMapping("/status/{id}")
	public ResponseEntity<Status> updateStatus(@PathVariable Long id, @RequestBody Status statusDetails){
		Status status = statusRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Status not exist with id :" + id));
		
		status.setStatus_descr(statusDetails.getStatus_descr());
		
		
		Status updatedStatus = statusRepository.save(status);
		return ResponseEntity.ok(updatedStatus);
	}
	
	// delete status
	@DeleteMapping("/status/{id}")
	public ResponseEntity <Map<String, Boolean>> deleteStatus(@PathVariable Long id){
		Status status = statusRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Status not exist with id :" + id));
		statusRepository.delete(status);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
				
	}
	
}
