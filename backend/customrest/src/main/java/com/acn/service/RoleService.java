package com.acn.service;

import java.util.Optional;

import com.acn.model.Role;

public interface RoleService {
	Optional<Role> findRoleByName(String name);
}
