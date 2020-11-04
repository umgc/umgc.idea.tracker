
package com.example.projecttracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.projecttracker.model.Project;
import com.example.projecttracker.repository.ProjectRepository;

@RestController
public class ProjectControllerDelete {
	
	@Autowired
	private ProjectRepository  repo;
	
	@RequestMapping(value="/project/{id}", method=RequestMethod.GET)
	public Project firstPage() {
		
		Project pro = new Project();
		pro.id = 1;
		pro.project_title = "Tracker";
		pro.project_description = "How to track proposal";
		pro.project_website = "www.Tracker.com";
		pro.comment = "Good";
	
		repo.delete(pro);
		
		return pro;
		
		
		
	}
	

}
