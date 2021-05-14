package com.acn.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.acn.model.Customer;

public interface CustomerDao{
	
	List<Customer> getAllCustomer();
	Customer getCustomerById(Long id);
	Optional<Customer> getOptionalCustomerById(Long id);
	List<Customer> getAllCustomerByName(String fname, String lname);
	List<Customer> getAllCustomerByCity(String city);
	Customer saveCustomer(Customer cust);
	Customer saveChangeCustomer(Customer cust);
	boolean deleteCustomer(Customer cust);
	boolean deleteCustomer(Long id);

}
