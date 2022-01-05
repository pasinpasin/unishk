package com.unishk.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.unishk.entity.Role;
import com.unishk.entity.User;



public class UnishkUserDetails implements UserDetails {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;

	public UnishkUserDetails(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Role> roles = user.getRoles();
		List<SimpleGrantedAuthority> authorities= new ArrayList<>();
		
		for (Role role: roles  )
		 {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
			
		 }
		
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		return user.isEnabled();
	}
	
	
	public String getFullname()
	{
		return this.user.getFirstName() + " " + this.user.getLastName();
	}
	
	public void setFirstname(String firstName)
	{
		this.user.setFirstName(firstName);
		
	}
	
	public void setLastname(String lastName)
	
	{
		this.user.setLastName(lastName);
	
		
	}
	
	public String getDepartament()
	{
		return this.user.getDepartamenti().getEmertimi();
	}
	public String getFakultet()
	{
		return this.user.getFakulteti().getId().toString();
	}
	
	public Integer getUserId()
	{
		return this.user.getId();
	}
	
	public boolean hasRole(String roleName)
	{
		return user.hasRole(roleName);
	}

}
