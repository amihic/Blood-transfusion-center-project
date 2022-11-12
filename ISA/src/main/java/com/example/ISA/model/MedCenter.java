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
    private String centerName;
   
    @OneToOne(fetch = FetchType.EAGER)
    private Address address;
   
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
	
	public MedCenter(int id, String centerName, Address address, String description, Set<Rating> rating,
			Set<Appointment> availableAppointments, Set<AdminEmployee> adminEmployees) {
		super();
		this.id = id;
		this.centerName = centerName;
		this.address = address;
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
	
	public String getCenterName() {
		return centerName;
	}
	
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
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