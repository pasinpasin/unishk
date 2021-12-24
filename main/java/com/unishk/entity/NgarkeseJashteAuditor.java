package com.unishk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;


@Table(name="ngarkese_jashte_auditor")
@Entity
public class NgarkeseJashteAuditor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(mappedBy = "ngarkesejashteauditor")
    private Ngarkesa ngarkese;
	
	@Column(length=50, nullable=false)
	 private String diplomecikli1="0";
	
	@Column(length=50, nullable=false)
	 private String diplomecikli2="0";
	
	@Column(length=50, nullable=false)
	 private String diplomecikli3="0";
	
	@Column(length=50, nullable=false)
	 private String tezedoktorate="0";
	
	@Column(length=50, nullable=false)
	 private String oponencedoktorate="0";
	
	@Column(length=50, nullable=false)
	 private String kryetardoktorate="0";
	
	@Column(length=50, nullable=false)
	 private String anetardoktorate="0";
	
	@Formula("(select sum( (n.diplomecikli1  + 0.0) * 2  +(n.diplomecikli2 + 0.0 )  * 3  + "
			+ "(n.diplomecikli3 + 0.0 ) * 4 + (n.tezedoktorate + 0.0 )  * 5 + (n.oponencedoktorate + 0.0 )  * 6 + (n.kryetardoktorate + 0.0 )  * 5 + (n.anetardoktorate + 0.0 )  * 6 ) from ngarkese_jashte_auditor n where n.id=id)")
	private Double shuma;

	public NgarkeseJashteAuditor() {
		
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Ngarkesa getNgarkese() {
		return ngarkese;
	}

	public void setNgarkese(Ngarkesa ngarkese) {
		this.ngarkese = ngarkese;
	}

	public String getDiplomecikli1() {
		return diplomecikli1;
	}

	public void setDiplomecikli1(String diplomecikli1) {
		this.diplomecikli1 = diplomecikli1;
	}

	public String getDiplomecikli2() {
		return diplomecikli2;
	}

	public void setDiplomecikli2(String diplomecikli2) {
		this.diplomecikli2 = diplomecikli2;
	}

	public String getDiplomecikli3() {
		return diplomecikli3;
	}

	public void setDiplomecikli3(String diplomecikli3) {
		this.diplomecikli3 = diplomecikli3;
	}

	public String getTezedoktorate() {
		return tezedoktorate;
	}

	public void setTezedoktorate(String tezedoktorate) {
		this.tezedoktorate = tezedoktorate;
	}

	public String getOponencedoktorate() {
		return oponencedoktorate;
	}

	public void setOponencedoktorate(String oponencedoktorate) {
		this.oponencedoktorate = oponencedoktorate;
	}

	public String getKryetardoktorate() {
		return kryetardoktorate;
	}

	public void setKryetardoktorate(String kryetardoktorate) {
		this.kryetardoktorate = kryetardoktorate;
	}

	public String getAnetardoktorate() {
		return anetardoktorate;
	}

	public void setAnetardoktorate(String anetardoktorate) {
		this.anetardoktorate = anetardoktorate;
	}

	public Double getShuma() {
		return shuma;
	}

	public void setShuma(Double shuma) {
		this.shuma = shuma;
	}
	
	
	
	
	
	

}
