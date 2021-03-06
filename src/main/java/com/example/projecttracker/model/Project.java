package com.example.projecttracker.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="project_title")
	private String project_title;
	
	@Column(name ="project_description")
	private String project_description;
	
	@Column(name ="project_website")
	private String project_website;
	
	@Column(name ="comment")
	private String comment;
	
	public Project() {
		
		
	}
	
	
	
	public Project(String project_title, String project_description, String project_website, String comment) {
		super();
		this.project_title = project_title;
		this.project_description = project_description;
		this.project_website = project_website;
		this.comment = comment;
	}
	

	

public Project(long id, String project_title, String project_description, String project_website, String comment,
			Status status, User user) {
		super();
		this.id = id;
		this.project_title = project_title;
		this.project_description = project_description;
		this.project_website = project_website;
		this.comment = comment;
		this.status = status;
		this.user = user;
	}



	public Project(String project_title, String project_description, String project_website, String comment,
			User user) {
		super();
		this.project_title = project_title;
		this.project_description = project_description;
		this.project_website = project_website;
		this.comment = comment;
		//this.status = status;
		this.user = user;
	}




	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProject_title() {
		return project_title;
	}
	public void setProject_title(String project_title) {
		this.project_title = project_title;
	}
	public String getProject_description() {
		return project_description;
	}
	public void setProject_description(String project_description) {
		this.project_description = project_description;
	}
	public String getProject_website() {
		return project_website;
	}
	public void setProject_website(String project_website) {
		this.project_website = project_website;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@ManyToOne(targetEntity = Status.class)
    @JoinColumn(name ="sp_fk",referencedColumnName = "id")
	private Status status;
	
	@ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="up_fk",referencedColumnName = "id")
	private User user;
	
	@OneToMany(targetEntity = Attachment.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="pa_fk",referencedColumnName = "id")
	private List<Attachment> attachments;

	public List<Attachment> getAttachments() {
		return attachments;
	}



	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}
	
	



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	

}
