package com.acn.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class RestFilter extends OncePerRequestFilter{
	
	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String uri=request.getRequestURI();
		
		if(uri.startsWith("/api") || uri.equals("/login") ||
				uri.equals("/register") || uri.equals("/auth")
				|| uri.equals("/users")) {
			
			response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
			response.setHeader("Access-Control-Allow-Methods", "POST,GET,PUT,DELETE");
			response.setHeader("Access-Control-Max-Age", "3600");
			response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
			filterChain.doFilter(request, response);
		}else {
			
			response.setStatus(400);
			response.resetBuffer();
			
			response.getWriter().append("Bad Request!");
			
		}
			
	}

}
