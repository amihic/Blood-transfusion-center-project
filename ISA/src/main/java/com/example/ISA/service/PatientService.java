package com.example.ISA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ISA.model.Patient;
import com.example.ISA.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepository;

	public Patient save(Patient patient) {
		return this.patientRepository.save(patient);
	}
}
