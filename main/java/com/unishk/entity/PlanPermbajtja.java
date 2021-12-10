package com.unishk.entity;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

@Table(name="plan_permbajtja")
@Entity
public class PlanPermbajtja {
	
	
	
	
	public PlanPermbajtja() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@ManyToOne
    @JoinColumn(name = "plani_id", nullable=false)
	private PlanetMesimore planiMesimor;
	
	
	


	
	  public PlanPermbajtja( Double kredite, Double kot1, Double kot2) {
	  
	  this.kredite = kredite; 
	  this.TotSem1Rresht= kot1;
	  this.TotSem2Rresht= kot2;
	  }
	 


	

@Override
public String toString() {
	return "PlanPermbajtja [id=" + id + ", planiMesimor=" + planiMesimor 
			+  ", viti=" + viti + ", renditja=" + renditja + ", emertimi_lendes="
			+ emertimi_lendes + ", titullari=" + titullari + ", tipi_veprimtarise=" + tipi_veprimtarise + ", kredite="
			+ kredite + ", jave_sem1=" + jave_sem1 + ", leksione_sem1=" + leksione_sem1 + ", seminare_sem1="
			+ seminare_sem1 + ", laboratore_sem1=" + laboratore_sem1 + ", praktika_sem1=" + praktika_sem1 + ", sem1="
			+ sem1 + ", jave_sem2=" + jave_sem2 + ", leksione_sem2=" + leksione_sem2 + ", seminare_sem2="
			+ seminare_sem2 + ", laboratore_sem2=" + laboratore_sem2 + ", praktika_sem2=" + praktika_sem2 + ", sem2="
			+ sem2 + ", TotLeksione=" + TotLeksione + ", TotSem1Rresht=" + TotSem1Rresht + ", TotSem2Rresht="
			+ TotSem2Rresht + "]";
}






   @Column(length=1, nullable=false)
	private String viti;
	
	@Column(length=4, nullable=false)
	private String renditja;
	
	@Column(length=255, nullable=false)
	private String emertimi_lendes;
	
	@Column(length=150)
	private String titullari;
	
	@Column(length=1, nullable=false)
	private String tipi_veprimtarise;
	
	@Column(length=4, nullable=false)
	private Double kredite;
	
	@Column(length=5)
	private String jave_sem1="0";
	
	@Column(length=5)
	private String leksione_sem1="0";
	
	@Column(length=5)
	private String seminare_sem1="0";
	
	@Column(length=5)
	private String laboratore_sem1="0";
	
	@Column(length=5)
	private String praktika_sem1="0";
	
	@Column(length=5)
	private String sem1;
	
	@Column(length=5)
	private String jave_sem2 ="0";
	
	@Column(length=5)
	private String leksione_sem2="0";
	
	@Column(length=5)
	private String seminare_sem2="0";
	
	@Column(length=5)
	private String laboratore_sem2="0";
	
	@Column(length=5)
	private String praktika_sem2="0";
	
	@Column(length=5)
	private String sem2;
	
	
	@Formula("(select sum( case p.tipi_veprimtarise when 'm' then 0  else p.seminare_sem1 + p.praktika_sem1 + p.laboratore_sem1 + p.leksione_sem1 + 0.0 end ) from plan_permbajtja p where p.id=id)")
	private Double TotSem1Rresht;
	
	@Formula("(select sum( case p.tipi_veprimtarise when 'm' then 0  else p.seminare_sem2 + p.praktika_sem2 + p.laboratore_sem2 + p.leksione_sem2 + 0.0 end ) from plan_permbajtja p where p.id=id)")
	private Double TotSem2Rresht;
	
	@Formula("(select (p.jave_sem1 + 0.0) * (p.leksione_sem1 + 0.0) + (p.jave_sem2 + 0.0) * (p.leksione_sem2 + 0.0) from plan_permbajtja p where p.id=id)")
	public String TotLeksione;
	
	@Formula("(select (p.jave_sem1 + 0.0) * (p.seminare_sem1 + 0.0) + (p.jave_sem2 + 0.0) * (p.seminare_sem2 + 0.0) from plan_permbajtja p where p.id=id)")
	public String TotSeminare;
	
	@Formula("(select (p.jave_sem1 + 0.0) * (p.laboratore_sem1 + 0.0) + (p.jave_sem2 + 0.0) * (p.laboratore_sem2 + 0.0) from plan_permbajtja p where p.id=id)")
	public String TotLaboratore;
	
	@Formula("(select (p.jave_sem1 + 0.0) * (p.praktika_sem1 + 0.0) + (p.jave_sem2 + 0.0) * (p.praktika_sem2 + 0.0) from plan_permbajtja p where p.id=id)")
	public String TotPraktika;
	


	

	public String getViti() {
		return viti;
	}

	public void setViti(String viti) {
		this.viti = viti;
	}

	public String getRenditja() {
		return renditja;
	}

	public void setRenditja(String renditja) {
		this.renditja = renditja;
	}

	public String getEmertimi_lendes() {
		return emertimi_lendes;
	}

	public void setEmertimi_lendes(String emertimi_lendes) {
		this.emertimi_lendes = emertimi_lendes;
	}

	public String getTitullari() {
		return titullari;
	}

	public void setTitullari(String titullari) {
		this.titullari = titullari;
	}

	public String getTipi_veprimtarise() {
		return tipi_veprimtarise;
	}

	public void setTipi_veprimtarise(String tipi_veprimtarise) {
		this.tipi_veprimtarise = tipi_veprimtarise;
	}

	public Double getKredite() {
		return kredite;
	}

	public void setKredite(Double kredite) {
		this.kredite = kredite;
	}

	public String getJave_sem1() {
		return jave_sem1;
	}

	public void setJave_sem1(String jave_sem1) {
		this.jave_sem1 = jave_sem1;
	}

	public String getLeksione_sem1() {
		return leksione_sem1;
	}

	public void setLeksione_sem1(String leksione_sem1) {
		this.leksione_sem1 = leksione_sem1;
	}

	public PlanetMesimore getPlaniMesimor() {
		return planiMesimor;
	}

	public void setPlaniMesimor(PlanetMesimore planiMesimor) {
		this.planiMesimor = planiMesimor;
	}

	

	public String getLaboratore_sem1() {
		return laboratore_sem1;
	}

	public void setLaboratore_sem1(String laboratore_sem1) {
		this.laboratore_sem1 = laboratore_sem1;
	}

	public String getPraktika_sem1() {
		return praktika_sem1;
	}

	public void setPraktika_sem1(String praktika_sem1) {
		this.praktika_sem1 = praktika_sem1;
	}

	public String getSem1() {
		return sem1;
	}

	public void setSem1(String sem1) {
		this.sem1 = sem1;
	}

	public String getJave_sem2() {
		return jave_sem2;
	}

	public void setJave_sem2(String jave_sem2) {
		this.jave_sem2 = jave_sem2;
	}

	public String getLeksione_sem2() {
		return leksione_sem2;
	}

	public void setLeksione_sem2(String leksione_sem2) {
		this.leksione_sem2 = leksione_sem2;
	}

	


	public String getLaboratore_sem2() {
		return laboratore_sem2;
	}

	public void setLaboratore_sem2(String laboratore_sem2) {
		this.laboratore_sem2 = laboratore_sem2;
	}

	public String getPraktika_sem2() {
		return praktika_sem2;
	}

	public void setPraktika_sem2(String praktika_sem2) {
		this.praktika_sem2 = praktika_sem2;
	}

	public String getSem2() {
		return sem2;
	}

	public void setSem2(String sem2) {
		this.sem2 = sem2;
	}



	public Integer getId() {
	    return id;
	}

	public void setId(Integer id) {
	    this.id = id;
	}

	public String getSeminare_sem1() {
	    return seminare_sem1;
	}

	public void setSeminare_sem1(String seminare_sem1) {
	    this.seminare_sem1 = seminare_sem1;
	}

	public String getSeminare_sem2() {
	    return seminare_sem2;
	}

	public void setSeminare_sem2(String seminare_sem2) {
	    this.seminare_sem2 = seminare_sem2;
	}
	
	
	





	public String getTotLeksione() {
		return TotLeksione;
	}

	public void setTotLeksione(String totLeksione) {
		TotLeksione = totLeksione;
	}
	
	
	
	
	
	public Double getTotSem1Rresht() {
		return TotSem1Rresht;
	}

	public void setTotSem1Rresht(Double totSem1Rresht) {
		TotSem1Rresht = totSem1Rresht;
	}

	public Double getTotSem2Rresht() {
		return TotSem2Rresht;
	}

	public void setTotSem2Rresht(Double totSem2Rresht) {
		TotSem2Rresht = totSem2Rresht;
	}
	
	
	
	
	
	
	
	
	
		

}
