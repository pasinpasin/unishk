package com.unishk.entity;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OrderBy;



@Table(name="users")
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=128, nullable=false)
	private String email;
	
	@Column(length=64, nullable=false)
	private String password;
	
	@Column(name="first_name",length=45, nullable=false)
	private String firstName;
	
	@Column(name="last_name",length=95, nullable=false)
	private String lastName;
	
	private boolean enabled;
	
	
	@OneToOne
	@JoinColumn(name="fakulteti_id")
	private Fakulteti fakulteti;
	
	@OneToOne
	@JoinColumn(name="departamenti_id")
	private Departamenti departamenti;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="users_roles", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles = new HashSet<>();
	
	 @OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade=CascadeType.MERGE)
	 private Set<Ngarkesa> ngarkesat = new HashSet<>();
	

	public User(String email, String password, String firstName, String lastName, boolean enabled, Fakulteti fakulteti,
			Departamenti departamenti) {
	
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.enabled = enabled;
		this.fakulteti = fakulteti;
		this.departamenti = departamenti;
	}
	
	

	public User() {
		super();
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Fakulteti getFakulteti() {
		return fakulteti;
	}

	public void setFakulteti(Fakulteti fakulteti) {
		this.fakulteti = fakulteti;
	}

	public Departamenti getDepartamenti() {
		return departamenti;
	}

	public void setDepartamenti(Departamenti departamenti) {
		this.departamenti = departamenti;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	



	public Set<Ngarkesa> getNgarkesat() {
		return ngarkesat;
	}



	public void setNgarkesat(Set<Ngarkesa> ngarkesat) {
		this.ngarkesat = ngarkesat;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", enabled=" + enabled + ", fakulteti=" + fakulteti + ", departamenti="
				+ departamenti + ", roles=" + roles + ", ngarkesat=" + ngarkesat + "]";
	}
	
	public boolean hasRole(String rolename)
	{
		Iterator<Role> iterator= roles.iterator(); 
		while (iterator.hasNext())
		{
			Role role=iterator.next();
			if (role.getName().equals(rolename))
			{
				return true;
			}
		}
		
		return false;
	}




	
	
	
	
	
	
	
	
	

}
