package com.example.ISA.model;
import java.time.LocalTime;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Appointment {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   
    @Column
    private Date dateTime;
    
    @Column
    private LocalTime startTime;
    
    @Column
    private int duration;
   
    @Column
    private boolean deleted;
   
   
	public Appointment() {
		super();
	}
	
	public Appointment(int id, Date dateTime, LocalTime startTime, int duration, boolean deleted) {
		super();
		this.id = id;
		this.dateTime = dateTime;
		this.startTime = startTime;
		this.duration = duration;
		this.deleted = deleted;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public Date getDateTime() {
		return dateTime;
	}
	
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
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
   
   
   

}