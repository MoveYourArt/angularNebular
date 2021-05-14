package com.acn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.acn.model.User;
import com.acn.persistence.UserDao;

@Service
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public UserServiceImpl() {
	}
	
	
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		super();
		this.userDao = userDao;
	}




	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userDao.loadUserByUsername(username);
	}


	@Override
	public List<User> gatAllUsers() {
		

		
		return userDao.getAllUsers();
	}


	@Override
	public User save(User user) {
		
		return userDao.save(user);
	}


	@Override
	public Optional<User> findUserByName(String username) {
		
		return userDao.findUserByName(username);
	}

}
