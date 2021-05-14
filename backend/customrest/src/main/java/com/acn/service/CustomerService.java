package com.acn.service;

import java.util.List;
import java.util.Optional;

import com.acn.model.Address;
import com.acn.model.Customer;

public interface CustomerService {
	
	List<Customer> getAllCustomer();
	Customer getCustomerById(Long id);
	Optional<Customer> getOptionalCustomerById(Long id);
	List<Customer> getAllCustomerByName(String fname, String lname);
	List<Customer> getAllCustomerByCity(String city);
	Customer saveCustomer(Customer cust);
	Customer saveChangeCustomer(Customer cust);
	boolean deleteCustomer(Customer cust);
	boolean deleteCustomer(Long id);
	List<Address> getAddressListByCustomerId(Long id);

}
