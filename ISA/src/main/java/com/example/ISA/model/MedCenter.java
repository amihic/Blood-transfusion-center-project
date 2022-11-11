package com.example.ISA.model;
import java.util.*;


public class MedCenter {
   
   private int id;
   private String centerName;
   private String address;
   private String description;
   private Set<Rating> rating;
   private Set<Appointment> availableAppointments;
   private Set<AdminEmployee> adminEmployees;

}