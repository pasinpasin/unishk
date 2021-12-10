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
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Table(name="departamentet")
@Entity
public class Departamenti {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=200, nullable=false, unique=true)
	private String emertimi;
	
	
	 @ManyToOne
	@JoinColumn(name="fakulteti_id", nullable=false)
	private Fakulteti fakulteti;
	 
	 @OneToMany(mappedBy="departamenti",fetch = FetchType.LAZY,cascade=CascadeType.MERGE)
		private Set<ProgrameStudimi> programeStudimi = new HashSet<>();
	 
	 @OneToOne(mappedBy="departamenti")
	 private User users;
	 

	public Departamenti(String emertimi, Fakulteti fakulteti) {
		
		this.emertimi = emertimi;
		this.fakulteti = fakulteti;
	}
	
	

	public Departamenti() {
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

	public Fakulteti getFakulteti() {
		return fakulteti;
	}
	
	
	


	public void setFakulteti(Fakulteti fakulteti) {
		this.fakulteti = fakulteti;
	}

	public Set<ProgrameStudimi> getProgrameStudimi() {
		return programeStudimi;
	}

	public void setProgrameStudimi(Set<ProgrameStudimi> programeStudimi) {
		this.programeStudimi = programeStudimi;
	}
	
	 
	 
	
	

}
