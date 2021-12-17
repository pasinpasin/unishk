package com.unishk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Formula;

@Entity
public class NgarkesePermbajtja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
    @JoinColumn(name = "ngarkese_id", nullable=false)
	private Ngarkesa ngarkese;
	
	
	@Column(name="programi",length=250)
	private String programi;
	
	@Column(name="lenda",length=250)
	private String lenda;
	
	@Column(name="cikli",length=100)
	private String cikli;
	
	@Column(length=5)
	private String leksione="0";
	
	@Column(length=5)
	private String seminare="0";
	
	@Column(length=5)
	private String grseminare="0";
	
	@Column(length=5)
	private String laboratore="0";

	@Column(length=5)
	private String grlaboratore="0";
	
	@Column(length=5)
	private String praktika="0";
	
	@Column(length=5)
	private String koef="1";
	
	@Formula("(select sum( n.leksione  + 0.0  + ((n.seminare + 0.0 )  *  (n.grseminare + 0.0 )) + "
			+ "((n.laboratore + 0.0 )  *  (n.grlaboratore + 0.0 )) + ((n.praktika + 0.0 )  *  (n.koef + 0.0 ))) from ngarkesepermbajtja n where n.id=id)")
	private Double shuma;

}
