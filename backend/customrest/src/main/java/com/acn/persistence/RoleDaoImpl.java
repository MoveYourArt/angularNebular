package com.acn.persistence;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acn.model.Role;
import com.acn.repository.RoleRepository;

@Component
public class RoleDaoImpl implements RoleDao {

	private RoleRepository roleRepo;

	@Autowired
	public RoleDaoImpl(RoleRepository roleRepo) {
		super();
		this.roleRepo = roleRepo;
	}


	@Override
	public Optional<Role> findRoleByName(String name) {
		
		return roleRepo.findRoleByName(name);
	}

}
