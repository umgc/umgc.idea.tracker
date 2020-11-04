package com.example.projecttracker.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "status")
public class Status {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="status_descr")
	private String status_descr;
	
	
	public Status(String status_descr) {
		super();
		this.status_descr = status_descr;
	}
	
	
	
	
	
	public Status(long id, String status_descr) {
		super();
		this.id = id;
		this.status_descr = status_descr;
	}





	public Status() {
		
	}
	
	
	public long getId() {
		return id;
	}





	public void setId(long id) {
		this.id = id;
	}





	public String getStatus_descr() {
		return status_descr;
	}
	public void setStatus_descr(String status_descr) {
		this.status_descr = status_descr;
	}
//	@OneToMany(targetEntity = Project.class,cascade = CascadeType.ALL)
//    @JoinColumn(name ="sp_fk",referencedColumnName = "id")
//	private List<Project> projects;
//
//
//	public List<Project> getProjects() {
//		return projects;
//	}
//
//	public void setProjects(List<Project> projects) {
//		this.projects = projects;
//	}

}
