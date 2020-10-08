package edu.umgc.CaPPMS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usr_type")
public class Usr_Type {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="utype_descr")
	private String utype_descr;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUtype_descr() {
		return utype_descr;
	}

	public void setUtype_descr(String utype_descr) {
		this.utype_descr = utype_descr;
	}

	public Usr_Type(String utype_descr) {
		super();
		this.utype_descr = utype_descr;
	}
	
	public Usr_Type() {
		
	}
	
	
	
}
	