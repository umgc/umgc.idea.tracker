package com.example.projecttracker.dto;

import com.example.projecttracker.model.Project;

public class ProjectRequest {
private Project project;

public ProjectRequest(Project project) {
	super();
	this.project = project;
}

public Project getProject() {
	return project;
}

public void setProject(Project project) {
	this.project = project;
}

public ProjectRequest() {
	
}

}
