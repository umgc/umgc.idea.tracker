package com.example.projecttracker.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Usr_TypeUsersResponse {

	
	private String utype_descr;
	private String first_name;
	private String last_name;
	private String phone_number;
	private String email;
	// private String user_type;
	private String title;
	private String website;
	private String empl_id;
	
	
	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public String getUtype_descr() {
		return utype_descr;
	}
	
	public void setUtype_descr(String utype_descr) {
		this.utype_descr = utype_descr;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
		
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public String getUser_type() {
//		return user_type;
//	}
//
//	public void setUser_type(String user_type) {
//		this.user_type = user_type;
//	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmpl_id() {
		return empl_id;
	}

	public void setEmpl_id(String empl_id) {
		this.empl_id = empl_id;
	}

	public Usr_TypeUsersResponse() {
		
	}

	public Usr_TypeUsersResponse(String utype_descr, String first_name, String last_name, String phone_number,
			String email, String title, String website, String empl_id) {
		super();
		this.utype_descr = utype_descr;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone_number = phone_number;
		this.email = email;
		this.title = title;
		this.website = website;
		this.empl_id = empl_id;
	}

	

	
	
	
	
	
	
	
	
	
	
	
}
