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

import org.hibernate.annotations.OrderBy;

@Table(name="planet_mesimore")
@Entity
public class PlanetMesimore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=150, nullable=false)
	private String periudha;
	
	
	
	 @ManyToOne
     @JoinColumn(name="programi_id", nullable=false)
     private ProgrameStudimi programi;
	 
	 @Column(length=150, nullable=false)
	 private String status="Krijuar";
	 
	 
	 @OneToMany(mappedBy="planiMesimor",fetch = FetchType.LAZY,cascade=CascadeType.MERGE)
	 @OrderBy(clause = "renditja")
	 private Set<PlanPermbajtja> planPermbajtja = new HashSet<>();
	

	public PlanetMesimore() {
		super();
		
	}

	public PlanetMesimore(String periudha, ProgrameStudimi programi) {
		
		this.periudha = periudha;
		this.programi = programi;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPeriudha() {
		return periudha;
	}

	public void setPeriudha(String periudha) {
		this.periudha = periudha;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ProgrameStudimi getProgrami() {
	    return programi;
	}

	public void setProgrami(ProgrameStudimi programi) {
	    this.programi = programi;
	}

	public Set<PlanPermbajtja> getPlanPermbajtja() {
		return planPermbajtja;
	}

	public void setPlanPermbajtja(Set<PlanPermbajtja> planPermbajtja) {
		this.planPermbajtja = planPermbajtja;
	}




	
	
	
	
	
	
	
	
	 
	 
	    
	    

}
