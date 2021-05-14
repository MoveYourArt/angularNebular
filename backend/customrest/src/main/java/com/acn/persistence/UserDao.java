package com.acn.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.acn.model.User;

public interface UserDao extends UserDetailsService {

	List<User> getAllUsers();
	User save(User user);
	Optional<User> findUserByName(String username);
}
