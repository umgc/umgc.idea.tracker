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
import com.example.projecttracker.exception.ResourceNotFoundException;
import com.example.projecttracker.model.Status;
import com.example.projecttracker.repository.ProjectRepository;
import com.example.projecttracker.repository.StatusRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class StatusController {
	@Autowired
	private StatusRepository statusRepository;
	
	
	@Autowired
    private ProjectRepository projectRepository;
	
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
	
	@PostMapping("/submitProjects")
    public Status placeOrder(@RequestBody StatusProjectRequest request){
       return statusRepository.save(request.getStatus());
    }

    @GetMapping("/findAllOrders")
    public List<Status> findAllOrders(){
        return statusRepository.findAll();
    }


    @GetMapping("/getInfo")
    public List<StatusProjectResponse> getJoinInformation(){
        return statusRepository.getJoinInformation();
    }
	   
	
	
}
