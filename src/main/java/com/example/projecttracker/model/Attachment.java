package com.example.projecttracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "attachment")
public class Attachment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="file_name")
	private String file_name;
	
	@Column(name ="file_descr")
	private String file_descr;
	
	@Column(name ="file_path")
	private String file_path;

	public Attachment(long id, String file_name, String file_descr, String file_path) {
		super();
		this.id = id;
		this.file_name = file_name;
		this.file_descr = file_descr;
		this.file_path = file_path;
	}
	
	public Attachment() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_descr() {
		return file_descr;
	}

	public void setFile_descr(String file_descr) {
		this.file_descr = file_descr;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	
	
	
}
