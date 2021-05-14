package com.acn.persistence;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.acn.model.Role;
import com.acn.model.User;
import com.acn.repository.UserRepository;

@Component
public class UserDaoImpl implements UserDao {

	private UserRepository userRepo;
	
	public UserDaoImpl() {	
	}
	
	@Autowired
	public UserDaoImpl(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> user=userRepo.findUserByUserName(username);
		if(!user.isPresent()) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		
		
		return new org.springframework.security.core.userdetails.User(
				user.get().getUserName(), user.get().getPassword(), mapRolesToAuthority(user.get().getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthority(List<Role> roles) {
		
		return roles.stream().map(role->
		new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	public List<User> getAllUsers() {
		
		return userRepo.findAll();
	}

	@Override
	public User save(User user) {
		
		return userRepo.save(user);
	}

	@Override
	public Optional<User> findUserByName(String username) {
		
		return userRepo.findUserByUserName(username);
	}

	
	

}
