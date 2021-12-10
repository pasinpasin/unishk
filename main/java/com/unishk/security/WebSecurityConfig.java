package com.unishk.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;




@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UnishkUserDetailsService();
	}
	
	
	@Bean
	public BCryptPasswordEncoder PasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.authorizeRequests()
        .antMatchers("/**")
        .access("hasIpAddress('127.0.0.1') or hasIpAddress('::1') or isAuthenticated()")  // 127.0.0.1 and localhost do not need to authenticate on any url
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .permitAll();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		
		web.ignoring().antMatchers("/images/**","/js/**","/webjars/**");
	
	}
	
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(PasswordEncoder());

		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	

}
