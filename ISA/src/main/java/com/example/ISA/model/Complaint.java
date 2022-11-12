package com.example.ISA.model;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Complaint {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    private int id;
   
    @Column
    private String name;
   
    @Column
    private String description;
   
    @Column
    private ComplaintType complaintType;

   
	public Complaint() {
		super();
	}
	
	public Complaint(int id, String name, String description, ComplaintType complaintType) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.complaintType = complaintType;
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public ComplaintType getComplaintType() {
		return complaintType;
	}
	
	public void setComplaintType(ComplaintType complaintType) {
		this.complaintType = complaintType;
	}
	   
	   

}