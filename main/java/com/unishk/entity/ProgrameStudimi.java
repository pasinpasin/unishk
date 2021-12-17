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
import javax.persistence.Table;

@Table(name="programet")
@Entity
public class ProgrameStudimi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=255, nullable=false, unique=true)
	private String emertimi;
	
	@ManyToOne
	@JoinColumn(name="departamenti_id", nullable=false)
	private Departamenti departamenti;
	
	
	@OneToMany(mappedBy="programi",fetch = FetchType.EAGER,cascade=CascadeType.MERGE)
	private Set<PlanetMesimore> planetmesimore = new HashSet<>();
 

	public ProgrameStudimi(String emertimi, Departamenti departamenti) {
		
		this.emertimi = emertimi;
		this.departamenti = departamenti;
	}
	
	

	public ProgrameStudimi() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ProgrameStudimi(Integer id) {
		super();
		this.id = id;
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

	public Departamenti getDepartamenti() {
		return departamenti;
	}

	public void setDepartamenti(Departamenti departamenti) {
		this.departamenti = departamenti;
	}



	public Set<PlanetMesimore> getPlanetmesimore() {
	    return planetmesimore;
	}



	public void setPlanetmesimore(Set<PlanetMesimore> planetmesimore) {
	    this.planetmesimore = planetmesimore;
	}
	
	
	
	
	

}
