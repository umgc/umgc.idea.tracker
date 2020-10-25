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

import com.example.projecttracker.dto.ProjectRequest;
import com.example.projecttracker.dto.ProposalRequest;
import com.example.projecttracker.exception.ResourceNotFoundException;
import com.example.projecttracker.model.Project;
import com.example.projecttracker.model.User;
import com.example.projecttracker.repository.ProjectRepository;
import com.example.projecttracker.repository.StatusRepository;
import com.example.projecttracker.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ProposalController {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StatusRepository statusRepository;
	
	
	
//	@PostMapping("/submitProposal")
//	public User submitProposal(@RequestBody ProposalRequest request) {
//		return userRepository.save(request.getUser());
//		
//		
//	}
	@PostMapping("/submitProject")
	public Project submitProject(@RequestBody ProjectRequest project) {
		System.out.println(project.toString());
		return projectRepository.save(project.getProject());
		
		
		
		
	}
	@GetMapping("/findAllProposal")
	public List<Project> findAllProposal(){
		return projectRepository.findAll();
	}
	//get project by id
		@GetMapping("/findAllProposal/{id}")
		public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
			
			Project  project = projectRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Project not exist with id:"+id));
			return ResponseEntity.ok(project);
		}
		@PutMapping("/findAllProposal/{id}")
		public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody ProjectRequest projectDetails){
			Project project = projectRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Project not exist with id :" + id));
			
			project.setProject_title(projectDetails.getProject().getProject_title());
			project.setProject_description(projectDetails.getProject().getProject_description());
			project.setProject_website(projectDetails.getProject().getProject_website());
			project.setComment(projectDetails.getProject().getComment());
			project.getUser().setEmail(projectDetails.getProject().getUser().getEmail());
			project.getUser().setFirst_name(projectDetails.getProject().getUser().getFirst_name());
			project.getUser().setLast_name(projectDetails.getProject().getUser().getLast_name());
			project.getUser().setPhone_number(projectDetails.getProject().getUser().getPhone_number());
			project.getUser().setTitle(projectDetails.getProject().getUser().getTitle());
			project.getUser().setUser_type(projectDetails.getProject().getUser().getUser_type());
			
			
			
			Project updatedProject = projectRepository.save(project);
			return ResponseEntity.ok(updatedProject);
		}
		// delete project
		@DeleteMapping("/findAllProposal/{id}")
		public ResponseEntity <Map<String, Boolean>> deleteProject(@PathVariable Long id){
			Project project = projectRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Project not exist with id :" + id));
			projectRepository.delete(project);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
					
		}
	
}
