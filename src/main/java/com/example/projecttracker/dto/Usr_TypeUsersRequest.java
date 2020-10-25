package com.example.projecttracker.dto;

import com.example.projecttracker.model.Usr_Type;


public class Usr_TypeUsersRequest {
	
	private Usr_Type usr_type;

	public Usr_TypeUsersRequest(Usr_Type usr_type) {
		super();
		this.usr_type = usr_type;
	}
	
	public Usr_TypeUsersRequest() {
		
	}

	public Usr_Type getUsr_type() {
		return usr_type;
	}

	public void setUsr_type(Usr_Type usr_type) {
		this.usr_type = usr_type;
	}

	
	
	
	
}
