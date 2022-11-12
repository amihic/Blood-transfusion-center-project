package com.example.ISA.model;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class SystemAdmin extends User {
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Complaint> respondedComplaints;

	public SystemAdmin() {
		super();
	}

	public SystemAdmin(Set<Complaint> respondedComplaints) {
		super();
		this.respondedComplaints = respondedComplaints;
	}

	public Set<Complaint> getRespondedComplaints() {
		return respondedComplaints;
	}

	public void setRespondedComplaints(Set<Complaint> respondedComplaints) {
		this.respondedComplaints = respondedComplaints;
	}
	
	

}