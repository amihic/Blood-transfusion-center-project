package com.example.ISA.model;
import java.time.LocalTime;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class WorkHour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   
    @Column
    private Day day;
   
    @Column
    private LocalTime workHourFrom;
   
    @Column
    private LocalTime workHourTo;
   
    @ManyToOne(fetch = FetchType.EAGER)
    private MedCenter medCenter;
   
    @Column
    private boolean deleted;
    
   
	public WorkHour() {
		super();
	}

	public WorkHour(int id, Day day, LocalTime workHourFrom, LocalTime workHourTo, MedCenter medCenter,
			boolean deleted) {
		super();
		this.id = id;
		this.day = day;
		this.workHourFrom = workHourFrom;
		this.workHourTo = workHourTo;
		this.medCenter = medCenter;
		this.deleted = deleted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public LocalTime getWorkHourFrom() {
		return workHourFrom;
	}

	public void setWorkHourFrom(LocalTime workHourFrom) {
		this.workHourFrom = workHourFrom;
	}

	public LocalTime getWorkHourTo() {
		return workHourTo;
	}

	public void setWorkHourTo(LocalTime workHourTo) {
		this.workHourTo = workHourTo;
	}

	public MedCenter getMedCenter() {
		return medCenter;
	}

	public void setMedCenter(MedCenter medCenter) {
		this.medCenter = medCenter;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

    
}