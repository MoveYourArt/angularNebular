package com.acn.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acn.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

		//User findUserByUserName(String username);
		Optional<User> findUserByUserName(String username);
		
		
}
