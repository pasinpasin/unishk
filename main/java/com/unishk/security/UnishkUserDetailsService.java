package com.unishk.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.unishk.entity.User;
import com.unishk.repository.UserRepository;



public class UnishkUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepo.getUserByEmail(email);
		
		if (user != null)
		{
			
			return new UnishkUserDetails(user);
			
		}
		
		throw new UsernameNotFoundException("nuk gjendet user me email " + email);
	}
	
	
	
	
	

}
