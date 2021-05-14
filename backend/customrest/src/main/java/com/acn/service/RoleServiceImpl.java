package com.acn.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acn.model.Role;
import com.acn.persistence.RoleDao;

@Service
public class RoleServiceImpl implements RoleService {

	private RoleDao roleDao;
	
	@Autowired
	public RoleServiceImpl(RoleDao roleDao) {
		super();
		this.roleDao = roleDao;
	}


	@Override
	public Optional<Role> findRoleByName(String name) {
		
		return roleDao.findRoleByName(name);
	}

}
