package com.acn.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.acn.model.Customer;
import com.acn.repository.CustomerRepository;
@Component
public class CustomerDaoIpl implements CustomerDao {

	private CustomerRepository repo;
	

	public CustomerDaoIpl() {
		super();
		
	}

	@Autowired
	public CustomerDaoIpl(CustomerRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<Customer> getAllCustomer() {

		return repo.findAll();
	}

	@Override
	public Customer getCustomerById(Long id) {
		
		
		return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("bad ID"));
	}

	@Override
	public Optional<Customer> getOptionalCustomerById(Long id) {
		
		return repo.findById(id);
	}

	@Override
	public List<Customer> getAllCustomerByName(String fname, String lname) {
		return repo.findByFnameAndLname(fname, lname);
	}

	@Override
	public List<Customer> getAllCustomerByCity(String city) {
		
		return repo.findByAddressListCity(city);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,
								isolation = Isolation.READ_COMMITTED)
	public Customer saveCustomer(Customer cust) {
		return repo.save(cust);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,
					isolation = Isolation.READ_COMMITTED)
	public Customer saveChangeCustomer(Customer cust) {
		
		return repo.save(cust);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,
					isolation = Isolation.READ_COMMITTED)
	public boolean deleteCustomer(Customer cust) {
		repo.delete(cust);
		return true;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,
	isolation = Isolation.READ_COMMITTED)
	public boolean deleteCustomer(Long id) {
		
		Optional<Customer> cust =repo.findById(id);
		if(cust.isPresent()) {
			repo.delete(cust.get());
			return true;
		}
			
		return false;
	}



}
