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
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OrderBy;

@Table(name="ngarkesa", uniqueConstraints=@UniqueConstraint(columnNames={"vitiakademik", "user_id", "departamenti_id"}))
@Entity
public class Ngarkesa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@ManyToOne
    @JoinColumn(name = "user_id", nullable=false)
	private User user;
	
	@ManyToOne
    @JoinColumn(name = "fakulteti_id", nullable=false)
	private Fakulteti fakulteti_ngarkesa;
	
	@ManyToOne
    @JoinColumn(name = "departamenti_id", nullable=false)
	private Departamenti departamenti_ngarkesa;
	
	@OneToMany(mappedBy="ngarkese",fetch = FetchType.LAZY,cascade=CascadeType.MERGE)
	 @OrderBy(clause = "id")
	 private Set<NgarkesePermbajtja> ngarkesePermbajtja = new HashSet<>();
	
	@Column(name="vitiakademik", nullable=false,length=11)
	private String vitiakademik;
	
	@Column(name="normamesimore", nullable=false,length=10)
	private String normamesimore;
	
	@Column(length=50, nullable=false)
	 private String status="Krijuar";
	
	

	public Ngarkesa(User user, Departamenti departamenti_ngarkesa, String vitiakademik) {
	
		this.user = user;
		this.departamenti_ngarkesa = departamenti_ngarkesa;
		this.vitiakademik = vitiakademik;
	}

	public Ngarkesa() {
		
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Departamenti getDepartamenti_ngarkesa() {
		return departamenti_ngarkesa;
	}

	public void setDepartamenti_ngarkesa(Departamenti departamenti_ngarkesa) {
		this.departamenti_ngarkesa = departamenti_ngarkesa;
	}
	
	

	public Fakulteti getFakulteti_ngarkesa() {
		return fakulteti_ngarkesa;
	}

	public void setFakulteti_ngarkesa(Fakulteti fakulteti_ngarkesa) {
		this.fakulteti_ngarkesa = fakulteti_ngarkesa;
	}

	public String getVitiakademik() {
		return vitiakademik;
	}

	public void setVitiakademik(String vitiakademik) {
		this.vitiakademik = vitiakademik;
	}

	public String getNormamesimore() {
		return normamesimore;
	}

	public void setNormamesimore(String normamesimore) {
		this.normamesimore = normamesimore;
	}

	public Set<NgarkesePermbajtja> getNgarkesePermbajtja() {
		return ngarkesePermbajtja;
	}

	public void setNgarkesePermbajtja(Set<NgarkesePermbajtja> ngarkesePermbajtja) {
		this.ngarkesePermbajtja = ngarkesePermbajtja;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	


	
	
	
	
	
	
	
	
	


}
