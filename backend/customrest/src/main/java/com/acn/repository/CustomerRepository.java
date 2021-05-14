package com.acn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acn.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	List<Customer> findByFnameAndLname(String firtname,String lastname);
	List<Customer> findByAddressListCity(String city);
}
