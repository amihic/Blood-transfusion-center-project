package com.example.ISA.model;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   
    @Column
    private Date dateFrom;
   
    @Column
    private Date dateTo;
   
    @ManyToOne(fetch = FetchType.EAGER)
    private AdminEmployee employee;
   
    @Column
    private boolean deleted;

    
	public Vacation() {
		super();
	}

	public Vacation(int id, Date dateFrom, Date dateTo, AdminEmployee employee, boolean deleted) {
		super();
		this.id = id;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.employee = employee;
		this.deleted = deleted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public AdminEmployee getEmployee() {
		return employee;
	}

	public void setEmployee(AdminEmployee employee) {
		this.employee = employee;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

    
}