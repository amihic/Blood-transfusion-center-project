package com.example.ISA.model;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   
    @Column
    private double bloodQuantity;
    

	public Warehouse() {
		super();
	}

	public Warehouse(int id, double bloodQuantity) {
		super();
		this.id = id;
		this.bloodQuantity = bloodQuantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBloodQuantity() {
		return bloodQuantity;
	}

	public void setBloodQuantity(double bloodQuantity) {
		this.bloodQuantity = bloodQuantity;
	}
   
   

}