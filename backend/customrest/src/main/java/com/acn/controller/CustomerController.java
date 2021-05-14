package com.acn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acn.model.Address;
import com.acn.model.Customer;
import com.acn.model.Role;
import com.acn.model.User;
import com.acn.service.CustomerService;
import com.acn.service.UserService;

@RestController
@RequestMapping("/api")
public class CustomerController {

	private CustomerService custService;
		
	public CustomerController() {
	}
	


	@Autowired
	public CustomerController(CustomerService custService) {
		super();
		this.custService = custService;
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomer(){		
		return ResponseEntity.ok(custService.getAllCustomer());						
	}
	
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Long id){		
		return ResponseEntity.ok(custService.getCustomerById(id));						
	}
	
	@GetMapping("/customer")
	public ResponseEntity<Customer> getCustomerByIdParam(@RequestParam Long id){
		return ResponseEntity.ok(custService.getCustomerById(id));						
	}
	
	
	@GetMapping("/customer/by/{city}")
	public ResponseEntity<List<Customer>> getCustomerByCity(@PathVariable(value = "city") String city){		
		return ResponseEntity.ok(custService.getAllCustomerByCity(city));						
	}
	
	@GetMapping("/customer/{fname}/{lname}")
	public ResponseEntity<List<Customer>> getCustomerByName(@PathVariable(value = "fname") String fname,
															@PathVariable(value = "lname") String lname){		
		return ResponseEntity.ok(custService.getAllCustomerByName(fname, lname));						
	}
	
	@GetMapping("/customer/Address/{id}")
	public ResponseEntity<List<Address>> getAddressListByCustomerId(@PathVariable(value = "id") Long id) {
		
		return ResponseEntity.ok(custService.getAddressListByCustomerId(id));
	}
	
	
	@PostMapping(path =  "/customers", 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
			
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){	
		
		return ResponseEntity.accepted().body(custService.saveCustomer(customer));						
	}
	
	@PutMapping(path =  "/customers",
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){	
		
		return ResponseEntity.accepted().body(custService.saveChangeCustomer(customer));						
	}
	
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<Void> daleteById(@PathVariable(value = "id") Long id){		
		return custService.deleteCustomer(id)?ResponseEntity.accepted()
				.build():ResponseEntity.badRequest().build();						
	}
	
	@DeleteMapping(path =  "/customer",
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> daleteCustomer(@RequestBody Customer customer){		
		return custService.deleteCustomer(customer)?ResponseEntity.accepted()
				.build():ResponseEntity.badRequest().build();						
	}

}
