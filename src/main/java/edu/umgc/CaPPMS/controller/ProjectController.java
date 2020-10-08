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
import edu.umgc.CaPPMS.model.Project;
import edu.umgc.CaPPMS.repository.ProjectRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cappms")
public class ProjectController {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	
	//get all project
	@GetMapping("/project")
	public List<Project> getAllProject(){
		
		return projectRepository.findAll();
	}
	//create Project
	@PostMapping("/project")
	public Project createProject(@RequestBody Project project) {
		return projectRepository.save(project);
	}
	//get project by id
	@GetMapping("/project/{id}")
	public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
		
		Project  project = projectRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Project not exist with id:"+id));
		return ResponseEntity.ok(project);
		
	}
	//Update project
	@PutMapping("/project/{id}")
	public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project projectDetails){
		Project project = projectRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Project not exist with id :" + id));
		
		project.setProject_title(projectDetails.getProject_title());
		project.setProject_description(projectDetails.getProject_description());
		project.setProject_website(projectDetails.getProject_website());
		project.setComment(projectDetails.getComment());
		
		Project updatedProject = projectRepository.save(project);
		return ResponseEntity.ok(updatedProject);
	}
	
	// delete project
	@DeleteMapping("/project/{id}")
	public ResponseEntity <Map<String, Boolean>> deleteProject(@PathVariable Long id){
		Project project = projectRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Project not exist with id :" + id));
		projectRepository.delete(project);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
				
	}
	
}
