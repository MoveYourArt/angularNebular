package com.acn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.acn.model.User;

public interface UserService extends UserDetailsService {
   
	List<User> gatAllUsers();

	User save(User user);
	
	Optional<User> findUserByName(String username);
}
