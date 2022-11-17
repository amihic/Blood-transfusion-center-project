package com.example.ISA.model;


import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



@Entity( name = "MedUser" )
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   
    @Column
    private String email;

    @Column
    private String password;
    
    @Column
    private String firstName;
   
    @Column
    private String lastName;
   
    //@OneToOne(fetch = FetchType.EAGER)
    @Column
    private String address;
    
    @Column
    private String city;
    
    @Column
    private String country;
   
    @Column
    private String phoneNumber;
   
    @Column
    private String jmbg;
   
   
    @Column
    private GenderType gender;
   
    @Column
    private String job;
   
    @Column
    private String info;
    
   
	public User() {
		super();
	}
	
	 public User(User user) {
	       this(user.getId(), user.getEmail(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getAddress(), user.getCity(), user.getCountry(),user.getPhoneNumber(), user.getJmbg(),user.getGender(),user.getJob() ,user.getInfo()  );
	    }

	public User(int id, String email, String password, String firstName, String lastName, String address, String city, String country,
			String phoneNumber, String jmbg, GenderType gender, String job, String info) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.jmbg = jmbg;
		this.gender = gender;
		this.job = job;
		this.info = info;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}


	public GenderType getGender() {
		return gender;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
   
   

}