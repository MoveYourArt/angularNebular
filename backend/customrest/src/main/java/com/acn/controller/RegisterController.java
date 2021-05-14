package com.acn.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acn.model.Role;
import com.acn.model.User;
import com.acn.service.RoleService;
import com.acn.service.UserService;

@Controller
@RequestMapping("/")
public class RegisterController {

	
	private UserService userService;
	private BCryptPasswordEncoder encoder;
	private RoleService roleService;
	
	@Autowired
	public RegisterController(UserService userService,
			BCryptPasswordEncoder encoder,
			RoleService roleService) {
		super();
		this.userService = userService;
		this.encoder = encoder;
		this.roleService=roleService;
	}


	
	@PostMapping("user/register")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		
		Optional<User> existUser=userService.findUserByName(user.getUserName());
		
		if(existUser.isPresent()) {
			throw new IllegalArgumentException("user exist");
		}
		
		Optional<Role> role=roleService.findRoleByName(user.getRoles().get(0).getName());
		
		if(role.isPresent()) {
			user.getRoles().get(0).setId(role.get().getId());
		}
		user.setPassword(encoder.encode(user.getPassword()));
		
		return ResponseEntity.accepted().body(userService.save(user));
	}
	
	@GetMapping("/auth")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Boolean> isAuthenticated() {
		
		return ResponseEntity.ok(new Boolean(true));
	}
	
	@GetMapping("/users")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<List<User>> getAllUsers(){
		
		return ResponseEntity.ok(userService.gatAllUsers());
	}

}
