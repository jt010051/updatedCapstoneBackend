package com.capstone.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import com.capstone.security.JWTService;

@RestController
@RequestMapping("/api/auth")
public class ValidateUserController {
	
	@Autowired
	JWTService jwtService;
	
	@RequestMapping("/validate")
	public Map<String, String> userIsValid() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User currentUser = (User) auth.getPrincipal();
		String name = currentUser.getUsername();
		String role = currentUser.getAuthorities().toArray()[0].toString().substring(5);
		
		String token = jwtService.generateToken(name, role);
		
		Map<String, String> results = new HashMap<String, String>();
		results.put("result", token);
		
		return results;
	}

}
