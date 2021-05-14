package com.acn.persistence;

import java.util.Optional;

import com.acn.model.Role;

public interface RoleDao {

	Optional<Role> findRoleByName(String name);
}
