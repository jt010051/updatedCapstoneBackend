package com.capstone.Config;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.capstone.security.JWTAuthorizationFilter;

@Configuration
@EnableWebSecurity
public class RestSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("teo").password("{noop}password").authorities("ROLE_ADMIN")
			.and()
			.withUser("holly").password("{noop}password").authorities("ROLE_USER");
		// TODO encode later
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers(HttpMethod.OPTIONS, "/api/auth/**").permitAll()
			.antMatchers("/api/auth/**").hasAnyRole("ADMIN", "USER")
			.and().httpBasic();
		
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers(HttpMethod.OPTIONS, "/api/**").permitAll()
			.antMatchers(HttpMethod.GET, "/api/**").permitAll()
			.antMatchers("/api/**").hasRole("ADMIN")
			.and()
			.addFilter(new JWTAuthorizationFilter(authenticationManager()));
	}

}
