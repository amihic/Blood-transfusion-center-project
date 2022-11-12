package com.example.ISA.model;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class AdminEmployee extends User {
   
    @ManyToOne(fetch = FetchType.EAGER)
    private MedCenter medCenter;
   
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private WorkCalendar workCalendar;
   
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<WorkHour> workHour;

    
	public AdminEmployee() {
		super();
	}

	public AdminEmployee(MedCenter medCenter, WorkCalendar workCalendar, Set<WorkHour> workHour) {
		super();
		this.medCenter = medCenter;
		this.workCalendar = workCalendar;
		this.workHour = workHour;
	}
	
	

	public MedCenter getMedCenter() {
		return medCenter;
	}
	
	public void setMedCenter(MedCenter medCenter) {
		this.medCenter = medCenter;
	}
	
	public WorkCalendar getWorkCalendar() {
		return workCalendar;
	}
	
	public void setWorkCalendar(WorkCalendar workCalendar) {
		this.workCalendar = workCalendar;
	}
	
	public Set<WorkHour> getWorkHour() {
		return workHour;
	}
	
	public void setWorkHour(Set<WorkHour> workHour) {
		this.workHour = workHour;
	}

   
}