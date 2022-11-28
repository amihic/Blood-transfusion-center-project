package com.example.ISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ISA.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
