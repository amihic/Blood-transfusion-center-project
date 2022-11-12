package com.example.ISA.model;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class WorkCalendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Appointment> appointments;
   
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Vacation> vacations;
    
   
	public WorkCalendar() {
		super();
	}

	public WorkCalendar(int id, Set<Appointment> appointments, Set<Vacation> vacations) {
		super();
		this.id = id;
		this.appointments = appointments;
		this.vacations = vacations;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}

	public Set<Vacation> getVacations() {
		return vacations;
	}

	public void setVacations(Set<Vacation> vacations) {
		this.vacations = vacations;
	}

     
}