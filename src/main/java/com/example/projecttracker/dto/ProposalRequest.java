package com.example.projecttracker.dto;

import com.example.projecttracker.model.User;

public class ProposalRequest {
	
	private User user;

	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ProposalRequest(User user) {
		super();
		this.user = user;
	}
	
	public ProposalRequest () {
		
	}

	@Override
	public String toString() {
		return "ProposalRequest [user=" + user + "]";
	}
	

}
