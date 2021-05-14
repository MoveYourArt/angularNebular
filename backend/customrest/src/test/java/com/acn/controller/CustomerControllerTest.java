package com.acn.controller;

import static org.hamcrest.Matchers.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;


import com.acn.model.Address;
import com.acn.model.Customer;
import com.acn.service.CustomerService;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CustomerService custService;
	
	private static List<Customer> custList=new ArrayList<>();
	private static String json="";
	private static String address="";
	
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		
		json="{\"id\":1,\"fname\":\"Pepe\","
				+ "\"lname\":\"Neue\",\"birthdate\":\"2002-10-20\","
				+ "\"addressList\":[{\"id\":1,\"zipcode\":\"98765\","
				+ "\"city\":\"Bremen\",\"stree\":\"Stree5\"},"
				+ "{\"id\":2,\"zipcode\":\"01234\",\"city\":\"Bremen\""
				+ ",\"stree\":\"Stree6\"}]}";
		
		address="[{\"id\":1,\"zipcode\":\"98765\","
				+ "\"city\":\"Bremen\",\"stree\":\"Stree5\"},"
				+ "{\"id\":2,\"zipcode\":\"01234\",\"city\":\"Bremen\""
				+ ",\"stree\":\"Stree6\"}]";
		
		Customer cust=new Customer(1L,"Pepe", "Neue",LocalDate.of(2002, 10, 20));	
		Address address= new Address(1L,"98765", "Bremen","Stree5");
		cust.addAddress(address);
		
		Customer cust1=new Customer(2L,"Pepe2", "Neue2",LocalDate.of(2002, 10, 21));	
		Address address1= new Address(2L,"01234", "Bremen","Stree6");
		cust1.addAddress(address1);
		cust1.addAddress(address);
		
		cust.addAddress(address1);
		
		custList.add(cust);
		custList.add(cust1);
	
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		custList=null;
	
	}
	



	@Test @Disabled
	void testGetAllCustomer() throws Exception {
		assertNotNull(mockMvc);
		assertNotNull(custService);		
		when(custService.getAllCustomer()).thenReturn(custList);
		
		mockMvc.perform(get("/api/customers")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].fname", is(custList.get(0).getFname())));
			
	}

	@Test @Disabled
	void testGetCustomerById() throws Exception {
		assertNotNull(mockMvc);
		assertNotNull(custService);		
		when(custService.getCustomerById(1L)).thenReturn(custList.get(0));
		
		mockMvc.perform(get("/api/customer/1")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(json));
		
	}

	@Test @Disabled
	void testGetCustomerByIdParam() throws Exception {
		assertNotNull(mockMvc);
		assertNotNull(custService);		
		when(custService.getCustomerById(1L)).thenReturn(custList.get(0));
		
		mockMvc.perform(get("/api/customer?id=1")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(json));
	}

	@Test @Disabled
	void testGetCustomerByCity() throws Exception {
		
		assertNotNull(mockMvc);
		assertNotNull(custService);		
		when(custService.getAllCustomerByCity("Bremen")).thenReturn(custList);
		
		mockMvc.perform(get("/api/customer/by/Bremen")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].fname", is(custList.get(0).getFname())));
		
	}

	@Test @Disabled
	void testGetCustomerByName() throws Exception {
		assertNotNull(mockMvc);
		assertNotNull(custService);		
		when(custService.getAllCustomerByName("Pepe", "Neue")).thenReturn(custList);
		
		mockMvc.perform(get("/api/customer/Pepe/Neue")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].fname", is(custList.get(0).getFname())));
	}
	
	@Test @Disabled
	void testGetAddressListByCustomerId() throws Exception {
		assertNotNull(mockMvc);
		assertNotNull(custService);	
		when(custService.getAddressListByCustomerId(1L)).thenReturn(custList.get(0).getAddressList());
		
		mockMvc.perform(get("/api/customer/Address/1")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(address));
	}

	@Test @Disabled
	void testSaveCustomer() throws Exception {
		assertNotNull(mockMvc);
		assertNotNull(custService);	
		Customer cust=custList.get(0);
	
		
		when(custService.saveCustomer(Mockito.any(Customer.class))).thenReturn(cust);
		
		mockMvc.perform(post("/api/customers")
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isAccepted())
				.andExpect(jsonPath("$.fname", is(cust.getFname())));
		
		verify(custService, times(1)).saveCustomer(Mockito.any(Customer.class));
				
	}

	@Test @Disabled
	void testUpdateCustomer() throws Exception {
		
		assertNotNull(mockMvc);
		assertNotNull(custService);	
		Customer cust=custList.get(0);
		when(custService.saveChangeCustomer(Mockito.any(Customer.class))).thenReturn(cust);
		
		mockMvc.perform(put("/api/customers")
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isAccepted())
				.andExpect(jsonPath("$.fname", is(cust.getFname())));
		
		verify(custService, times(1)).saveChangeCustomer(Mockito.any(Customer.class));
	}

	@Test @Disabled
	void testDaleteById() throws Exception {
		assertNotNull(mockMvc);
		assertNotNull(custService);	
		when(custService.deleteCustomer(1L)).thenReturn(true);
		
		mockMvc.perform(delete("/api/customer/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isAccepted());
		verify(custService, times(1)).deleteCustomer(1L);
	}

	@Test @Disabled
	void testDaleteCustomer() throws Exception {
		assertNotNull(mockMvc);
		assertNotNull(custService);	
		when(custService.deleteCustomer(Mockito.any(Customer.class))).thenReturn(true);
		
		mockMvc.perform(delete("/api/customer")
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isAccepted());
		
		verify(custService, times(1)).deleteCustomer(Mockito.any(Customer.class));
	}

}
