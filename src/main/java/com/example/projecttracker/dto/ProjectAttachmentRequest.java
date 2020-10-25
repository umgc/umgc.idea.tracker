package com.example.projecttracker.dto;

import com.example.projecttracker.model.Project;


public class ProjectAttachmentRequest {
	
	private Project project;

	public Project getProject() {
		return project;
	}


	public void setProject(Project project) {
		this.project = project;
	}


	public ProjectAttachmentRequest(Project project) {
		super();
		this.project = project;
	}

	public ProjectAttachmentRequest() {
		
	}
	
	
	
}
