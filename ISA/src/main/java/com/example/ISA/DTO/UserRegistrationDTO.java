package com.example.ISA.DTO;

import javax.persistence.Column;

import com.example.ISA.model.GenderType;

public class UserRegistrationDTO {

	
	private int id;
	   
    private String email;
   
    private String password1;
    
    private String password2;
    
    private String firstName;
   
    private String lastName;
   
    private String address;
    
    private String city;
    
    private String country;
   
    private String phoneNumber;
   
    private String jmbg;
   
    private GenderType gender;
   
    private String job;
   
    private String info;
    
    private boolean isActivated;
    
   
	public UserRegistrationDTO() {
		super();
	}

	public UserRegistrationDTO(int id, String email, String password1, String password2, String firstName, String lastName, String address, String city, String country,
			String phoneNumber, String jmbg, GenderType gender, String job, String info, boolean isActivated) {
		super();
		this.id = id;
		this.email = email;
		this.password1 = password1;
		this.password2 = password2;
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
		this.isActivated = isActivated;
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

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
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

	public boolean isActivated() {
		return isActivated;
	}

	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}
	
}
