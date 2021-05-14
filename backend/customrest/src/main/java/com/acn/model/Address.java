package com.acn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 10,nullable = false)
	private String zipcode;
	@Column(length = 40,nullable = false)
	private String city;
	@Column(length = 60,nullable = false)
	private String stree;

	public Address() {
		
	}

	public Address(String zipcode, String city, String stree) {
		super();
		this.zipcode = zipcode;
		this.city = city;
		this.stree = stree;
	}

	public Address(Long id, String zipcode, String city, String stree) {
		super();
		this.id = id;
		this.zipcode = zipcode;
		this.city = city;
		this.stree = stree;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStree() {
		return stree;
	}

	public void setStree(String stree) {
		this.stree = stree;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", zipcode=" + zipcode + ", city=" + city + ", stree=" + stree + "]";
	}
	
	

}
