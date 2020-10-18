package com.example.projecttracker.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class StatusProjectResponse {

	
	private String status_descr;
	
	public StatusProjectResponse(String status_descr, String project_title) {
		super();
		this.status_descr = status_descr;
		this.project_title = project_title;
	}
	
	public StatusProjectResponse() {
		
	}
	private String project_title;
    
	
    public String getProject_title() {
		return project_title;
	}
	public void setProject_title(String project_title) {
		this.project_title = project_title;
	}
	public String getStatus_descr() {
		return status_descr;
	}
	public void setStatus_descr(String status_descr) {
		this.status_descr = status_descr;
	}
	
	
	
	
}
