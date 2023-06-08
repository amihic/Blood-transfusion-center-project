package com.example.ISA.model;
import java.util.*;

import javax.persistence.*;

@Entity
public class Complaint {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    private int id;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Patient patient;
    @Column
    private String name;
   
    @Column
    private String description;
   
    @Column
    private ComplaintType complaintType;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private MedCenter medCenter;

   
	public Complaint() {
		super();
	}
	
	public Complaint(int id, String name, String description, ComplaintType complaintType, MedCenter medCenter) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.complaintType = complaintType;
		this.medCenter = medCenter;
	}

	public Complaint(Patient patient, String name, String description, ComplaintType complaintType, MedCenter medCenter) {
		super();
		this.patient = patient;
		this.name = name;
		this.description = description;
		this.complaintType = complaintType;
		this.medCenter = medCenter;
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

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public MedCenter getMedCenter() {
		return medCenter;
	}

	public void setMedCenter(MedCenter medCenter) {
		this.medCenter = medCenter;
	}
}