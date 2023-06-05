package com.example.ISA.model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
public class Appointment {
	
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private LocalDateTime start;
    
    @Column
    private int duration;
   
    @Column
    private boolean deleted;
    
    @Column
    private boolean reserved;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Patient patient;
   
	public Appointment() {
		super();
	}
	
	public Appointment(int id, LocalDateTime start, int duration, boolean deleted) {
		super();
		this.id = id;
		this.start = start;
		this.duration = duration;
		this.deleted = deleted;
	}
	
	public Appointment(LocalDateTime start, int duration, boolean reserved) {
		super();
		this.start = start;
		this.duration = duration;
		this.reserved = reserved;
	}
	
	public Appointment(LocalDateTime start, int duration, boolean deleted, boolean reserved) {
		super();
		this.start = start;
		this.duration = duration;
		this.deleted = deleted;
		this.reserved = reserved;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public LocalDateTime getStart() {
		return start;
	}
	
	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public boolean isDeleted() {
		return deleted;
	}
	
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
   
   
   

}