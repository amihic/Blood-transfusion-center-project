package com.example.ISA.model;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	   
	@Column
	private String street;
	   
	@Column
	private String city;
	   
	@Column
	private String country;
	   
	@Column
	private int number;
	
	
	public Address() {
		super();
	}

	public Address(int id, String street, String city, String country, int number) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
		this.country = country;
		this.number = number;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
		

   
   
}