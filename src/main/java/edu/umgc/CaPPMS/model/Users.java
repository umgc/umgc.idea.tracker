package edu.umgc.CaPPMS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="first_name")
	private String first_name;
	
	@Column(name ="last_name")
	private String last_name;
	
	@Column(name ="phone_number")
	private String phone_number;
	
	@Column(name ="email")
	private String email;
	
	@Column(name ="user_type")
	private long user_type;
		
	@Column(name ="title")
	private String title;
	
	@Column(name ="website")
	private String website;
	
	@Column(name ="empl_id")
	private String empl_id;

	public Users(String first_name, String last_name, String phone_number, String email, long user_type, String title,
			String website, String empl_id) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone_number = phone_number;
		this.email = email;
		this.user_type = user_type;
		this.title = title;
		this.website = website;
		this.empl_id = empl_id;
	}
	
	public Users() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getUser_type() {
		return user_type;
	}

	public void setUser_type(long user_type) {
		this.user_type = user_type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

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
	
	
	
	
	
	
	
	
	
}