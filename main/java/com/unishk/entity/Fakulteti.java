package com.unishk.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Table(name="fakultetet")
@Entity
public class Fakulteti {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=150, nullable=false, unique=true)
	private String emertimi;
	
	@OneToMany(mappedBy="fakulteti",fetch = FetchType.LAZY,cascade=CascadeType.MERGE)
	private Set<Departamenti> departamentet = new HashSet<>();
	
	 @OneToMany(mappedBy="fakulteti_ngarkesa",fetch = FetchType.LAZY,cascade=CascadeType.MERGE)
	 private Set<Ngarkesa> ngarkesat = new HashSet<>();
	
	@OneToOne(mappedBy="fakulteti")
	private User users;
	
	

	public Fakulteti(String emertimi) {
		
		this.emertimi = emertimi;
	}
	
	
	
	

	public Fakulteti(Integer id, String emertimi) {
	
		this.id = id;
		this.emertimi = emertimi;
	}
	
	public Fakulteti(Integer id) {
		
		this.id = id;
		
	}






	public Fakulteti() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmertimi() {
		return emertimi;
	}

	public void setEmertimi(String emertimi) {
		this.emertimi = emertimi;
	}


	public Set<Departamenti> getDepartamentet() {
		return departamentet;
	}


	public void setDepartamentet(Set<Departamenti> departamentet) {
		this.departamentet = departamentet;
	}


	public User getUsers() {
		return users;
	}


	public void setUsers(User users) {
		this.users = users;
	}





	public Set<Ngarkesa> getNgarkesat() {
		return ngarkesat;
	}





	public void setNgarkesat(Set<Ngarkesa> ngarkesat) {
		this.ngarkesat = ngarkesat;
	}
	
	
	
	
	

}
