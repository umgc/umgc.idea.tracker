package edu.umgc.CaPPMS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	public Status() {
				
	}

	public String getStatus_descr() {
		return status_descr;
	}

	public void setStatus_descr(String status_descr) {
		this.status_descr = status_descr;
	}
		
	
}