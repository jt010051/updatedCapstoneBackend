package com.capstone.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.auth0.jwt.exceptions.JWTVerificationException;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
	
	public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	JWTService jwtService;
	
	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		String header = request.getHeader("Authorization");
		if (header == null || !header.startsWith("Bearer")) {
			chain.doFilter(request, response);
			return;
		}
		
		if (jwtService == null) {
			ServletContext sevletContext = request.getServletContext();
			WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(sevletContext);
			jwtService = wac.getBean(JWTService.class);
		}
		
		UsernamePasswordAuthenticationToken authentication = getAuthentication(header);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(request, response);
	}
	
	private UsernamePasswordAuthenticationToken getAuthentication (String header) {
		String jwtToken = header.substring(7);
		try {
			String payload = jwtService.validateToken(jwtToken);
			JsonParser parser = JsonParserFactory.getJsonParser();
			Map<String, Object> payloadMap = parser.parseMap(payload);
			String user = payloadMap.get("user").toString();
			String role = payloadMap.get("role").toString();
			
			List<GrantedAuthority> roles = new ArrayList<>();
			GrantedAuthority ga = new GrantedAuthority() {

				@Override
				public String getAuthority() {
					return "ROLE_" + role;
				}
				
			};
			
			roles.add(ga);
			
			return new UsernamePasswordAuthenticationToken(user, null, roles);
		} catch (Exception e) {
			return null;
		}
	}
	
	
	
	

}
