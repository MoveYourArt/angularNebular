package com.acn.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 40,nullable = false)
	private  String fname;
	@Column(length = 40,nullable = false)
	private String lname;
	@Column(length = 30,nullable = false)
	private LocalDate birthdate;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "customerid")
	private List<Address> addressList;
	

	public Customer() {

		
	}

	public void addAddress(Address address) {
		
		if (addressList == null) {
			
			addressList= new ArrayList<>();
			
		}
		
		addressList.add(address);
	}

	public Customer(Long id, String fname, String lname, LocalDate birthdate) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.birthdate = birthdate;
	}


	public Customer(String fname, String lname, LocalDate birthdate) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.birthdate = birthdate;
	}



	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}



	public List<Address> getAddressList() {
		return addressList;
	}


	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", fname=" + fname + ", lname=" + lname + ", birthdate=" + birthdate
				+ ", addressList=" + addressList + "]";
	}
	
	

}
