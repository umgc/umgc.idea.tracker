package com.example.projecttracker.dto;

import com.example.projecttracker.model.Status;

public class StatusProjectRequest {
	private Status status;

	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public StatusProjectRequest(Status status) {
		super();
		this.status = status;
	}
	
	
	public StatusProjectRequest() {
		
	}

}
