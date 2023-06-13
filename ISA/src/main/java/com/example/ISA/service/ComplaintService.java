package com.example.ISA.service;

import com.example.ISA.model.MedCenter;
import com.example.ISA.repository.PatientRepository;
import com.example.ISA.repository.MedCenterRepository;
import com.example.ISA.model.Complaint;
import com.example.ISA.model.Patient;
import com.example.ISA.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private MedCenterRepository medCenterRepository;

    public Complaint save(String email, Complaint complaint, String medCenter) {
        List<Complaint> complaints = this.complaintRepository.findAll();
        Patient patient = this.patientRepository.findByEmail(email);
        MedCenter center = this.medCenterRepository.findByName(medCenter);
        int id=0;
        for ( Complaint c:complaints) {
            id=c.getId();
        }
        id=id+1;
        complaint.setId(id);
        complaint.setPatient(patient);
        complaint.setMedCenter(center);

        return this.complaintRepository.save(complaint);
    }
}
