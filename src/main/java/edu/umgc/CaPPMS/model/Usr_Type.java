package edu.umgc.CaPPMS.model;

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
	
	@OneToMany(targetEntity = Users.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="uu_fk",referencedColumnName = "id")
	private List<Users> users;


	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public Usr_Type(String utype_descr) {
		super();
		this.utype_descr = utype_descr;
	}
	
	public Usr_Type() {
		
	}
	
	
	
}
	