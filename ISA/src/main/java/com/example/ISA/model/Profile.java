package com.example.ISA.model;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Profile {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;
   
    @Column
    private CategoryType category;
   
    @Column
    private int points;
    
	public Profile() {
		super();
	}

	public Profile(int id, User user, CategoryType category, int points) {
		super();
		this.id = id;
		this.user = user;
		this.category = category;
		this.points = points;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CategoryType getCategory() {
		return category;
	}

	public void setCategory(CategoryType category) {
		this.category = category;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
    
    

}