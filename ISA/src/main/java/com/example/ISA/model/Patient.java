package com.example.ISA.model;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;


@Entity
public class Patient extends User {
	
    @Column
    private BloodType bloodType;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Complaint> complaints;
    
    @Column
    private int points;
    
    @Column
    private CategoryType category;
    
    @Column
    private int penalties;
    

	public Patient() {
		super();
	}
	
	public Patient(int id, String email, String password, String firstName, String lastName, String address, String city, String country,
			 String phoneNumber, String jmbg, GenderType gender, String job, String info, boolean enabled, String role, List<Authority> authorities) {
		super();
		setId(id);
		setEmail(email);
		setPassword(password);
		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
		setCity(city);
		setCountry(country);
		setPhoneNumber(phoneNumber);
		setJmbg(jmbg);
		setGender(gender);
		setJob(job);
		setInfo(info);
		setEnabled(enabled);
		setRole(role);
		setAuthorities(authorities);
	}

	public Patient(BloodType bloodType, Set<Complaint> complaints, int points, CategoryType category, int penalties) {
		super();
		this.bloodType = bloodType;
		this.complaints = complaints;
		this.points = points;
		this.category = category;
		this.penalties = penalties;
	}

	public BloodType getBloodType() {
		return bloodType;
	}

	public void setBloodType(BloodType bloodType) {
		this.bloodType = bloodType;
	}

	public Set<Complaint> getComplaints() {
		return complaints;
	}

	public void setComplaints(Set<Complaint> complaints) {
		this.complaints = complaints;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public CategoryType getCategory() {
		return category;
	}

	public void setCategory(CategoryType category) {
		this.category = category;
	}

	public int getPenalties() {
		return penalties;
	}

	public void setPenalties(int penalties) {
		this.penalties = penalties;
	}
    
    

}