package com.acn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.acn.model.Address;
import com.acn.model.Customer;
import com.acn.persistence.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerDao custDao;
	

	public CustomerServiceImpl() {
		super();
	
	}

	@Autowired
	public CustomerServiceImpl(CustomerDao custDao) {
		super();
		this.custDao = custDao;
	}

	@Override
	public List<Customer> getAllCustomer() {
		return custDao.getAllCustomer();
	}

	@Override
	public Customer getCustomerById(Long id) {
		return custDao.getCustomerById(id);
	}

	@Override
	public Optional<Customer> getOptionalCustomerById(Long id) {
		return custDao.getOptionalCustomerById(id);
	}

	@Override
	public List<Customer> getAllCustomerByName(String fname, String lname) {

		return custDao.getAllCustomerByName(fname, lname);
	}

	@Override
	public List<Customer> getAllCustomerByCity(String city) {

		return custDao.getAllCustomerByCity(city);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Customer saveCustomer(Customer cust) {
		return custDao.saveCustomer(cust);

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Customer saveChangeCustomer(Customer cust) {
		
		return custDao.saveChangeCustomer(cust);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public boolean deleteCustomer(Customer cust) {

		return custDao.deleteCustomer(cust);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public boolean deleteCustomer(Long id) {
	
		return custDao.deleteCustomer(id);
	}

	@Override
	public List<Address> getAddressListByCustomerId(Long id) {
		
		return custDao.getCustomerById(id).getAddressList();
	}

}
