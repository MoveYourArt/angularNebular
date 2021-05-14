package com.acn.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acn.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
	
	Optional<Role> findRoleByName(String name);

}
