package com.example.projecttracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "enabled")
	private Boolean isEnabled;
	
	@OneToOne
	private User user;
	
	
	public Account(String username, String password, boolean enabled)
	{
		super();
		this.username = username;
		this.password = password;
		this.isEnabled = enabled;
	}
	
}
