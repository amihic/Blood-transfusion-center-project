package com.example.ISA.model;
import java.util.*;


public class Patient extends User {
	
   private BloodType bloodType;
   private Set<Complaint> complaints;
   private int points;
   private CategoryType category;
   private int penalties;

}