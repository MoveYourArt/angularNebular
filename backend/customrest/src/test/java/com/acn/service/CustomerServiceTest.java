package com.acn.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.acn.model.Address;
import com.acn.model.Customer;

@SpringBootTest
class CustomerServiceTest {
	
	@Autowired
	private CustomerService service;

	//@Test
	void testGetAllCustomer() {
		assertNotNull(service);
		List<Customer> listCust=service.getAllCustomer();
		assertNotNull(listCust);
		assertTrue(listCust.size()>0);
	}

	//@Test
	void testGetCustomerById() {
		assertNotNull(service);
		Customer cust= service.getCustomerById(1L);
		assertNotNull(cust);
	}

	//@Test
	void testGetOptionalCustomerById() {
		assertNotNull(service);
		Optional<Customer> cust= service.getOptionalCustomerById(1L);
		assertTrue(cust.isPresent());
	}

	//@Test
	void testGetAllCustomerByName() {
		assertNotNull(service);
		List<Customer> cust= service.getAllCustomerByName("calo", "kate");
		assertNotNull(cust);
		assertTrue(cust.size()>0);
	}

	//@Test
	void testGetAllCustomerByCity() {
		assertNotNull(service);
		List<Customer> cust= service.getAllCustomerByCity("postdam");
		assertNotNull(cust);
		assertTrue(cust.size()>0);
	}

	//@Test
	void testSaveCustomer() {
		assertNotNull(service);
		Customer neueCust=new Customer("Pepe", "Neue",LocalDate.of(2002, 10, 20));
		Address address= new Address("98765", "Bremen","Stree5");
		neueCust.addAddress(address);
		Customer cust=service.saveCustomer(neueCust);
		assertNotNull(cust);
		assertEquals("Pepe",cust.getFname());
		assertEquals("Bremen",cust.getAddressList().get(0).getCity());
		
	}

	@Test
	void testSaveChangeCustomer() {
		assertNotNull(service);
		List<Customer> custList=service.getAllCustomer();
		assertNotNull(custList);
		Customer customer=custList.get(custList.size()-1);
		customer.setFname("new name");
		
		Customer newCust=service.saveChangeCustomer(customer);
		assertNotNull(newCust);
		assertEquals("new name",newCust.getFname());
	}

	//@Test
	void testDeleteCustomerCustomer() {
	
	}

	//@Test 
	void testDeleteCustomerLong() {
		
	}

}
