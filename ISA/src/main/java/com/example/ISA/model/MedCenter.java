package com.example.ISA.model;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class MedCenter {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   
    @Column
    private String name;
   
    @Column
    private String street;
    
    @Column
    private String city;
    
    @Column
    private String country;
   
    @Column
    private String description;
   
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Rating> rating;
   
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Appointment> availableAppointments;
   
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<AdminEmployee> adminEmployees;
   
   

	public MedCenter() {
		super();
	}
	
	public MedCenter(int id, String name, String street, String city, String country, String description, Set<Rating> rating,
			Set<Appointment> availableAppointments, Set<AdminEmployee> adminEmployees) {
		super();
		this.id = id;
		this.name = name;
		this.street = street;
		this.city = city;
		this.country = country;
		this.description = description;
		this.rating = rating;
		this.availableAppointments = availableAppointments;
		this.adminEmployees = adminEmployees;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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


	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<Rating> getRating() {
		return rating;
	}
	
	public void setRating(Set<Rating> rating) {
		this.rating = rating;
	}
	
	public Set<Appointment> getAvailableAppointments() {
		return availableAppointments;
	}
	
	public void setAvailableAppointments(Set<Appointment> availableAppointments) {
		this.availableAppointments = availableAppointments;
	}
	
	public Set<AdminEmployee> getAdminEmployees() {
		return adminEmployees;
	}
	
	public void setAdminEmployees(Set<AdminEmployee> adminEmployees) {
		this.adminEmployees = adminEmployees;
	}

   
}