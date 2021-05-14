package com.acn.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.acn.model.User;
import com.acn.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserNamePasswordAuthFilter extends UsernamePasswordAuthenticationFilter {

	 private AuthenticationManager authManager;
	 private UserService userService;
	 
	 
	public UserNamePasswordAuthFilter(AuthenticationManager authManager, UserService userService) {
		super();
		this.authManager = authManager;
		this.userService = userService;
	}
	 
	  @Override
	    public Authentication attemptAuthentication(HttpServletRequest request,
	            HttpServletResponse response) throws AuthenticationException {

	        try {
	            // Get username & password from request (JSON) any way you like
	            User authRequest = new ObjectMapper()
	                    .readValue(request.getInputStream(), User.class);
	            
	            Authentication auth = new UsernamePasswordAuthenticationToken(authRequest.getUserName(), 
	                    authRequest.getPassword());
	            
	            return authManager.authenticate(auth);
	        } catch (Exception exp) {
	            throw new RuntimeException(exp);
	        }
	    }
	    
	    @Override
	    protected void successfulAuthentication(HttpServletRequest request,
	            HttpServletResponse response, FilterChain chain, Authentication authResult)
	            throws IOException, ServletException {

	        if (logger.isDebugEnabled()) {
	            logger.debug("Authentication success. Updating SecurityContextHolder to contain: "
	                    + authResult);
	        }

	        // custom code
	        
	        SecurityContextHolder.getContext().setAuthentication(authResult);       
	    }

}
