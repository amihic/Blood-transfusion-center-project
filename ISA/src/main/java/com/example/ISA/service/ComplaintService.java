package com.example.ISA.service;

import com.example.ISA.model.MedCenter;
import com.example.ISA.repository.PatientRepository;
import com.example.ISA.repository.AppointmentRepository;
import com.example.ISA.repository.MedCenterRepository;
import com.example.ISA.model.Complaint;
import com.example.ISA.model.Patient;
import com.example.ISA.model.Appointment;
import com.example.ISA.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private MedCenterRepository medCenterRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    public Complaint save(String email, Complaint complaint, String medCenter) {
        List<Complaint> complaints = this.complaintRepository.findAll();
        Patient patient = this.patientRepository.findByEmail(email);
        MedCenter center = this.medCenterRepository.findByName(medCenter);
        if(historyCheck(patient, center)) {
            int id = 0;
            for (Complaint c : complaints) {
                id = c.getId();
            }
            id = id + 1;
            complaint.setId(id);
            complaint.setPatient(patient);
            complaint.setMedCenter(center);
            System.out.println("Korisnik " + patient.getEmail() + " je kreirao zalbu za: " + center.getName());
            return this.complaintRepository.save(complaint);
        }
        System.out.println("Korisnik " + patient.getEmail() + " nije imao ni jedan pregled u: " + center.getName() + " tako da nije u mogucnosti da posalje zalbu");
        return null;
    }

    boolean historyCheck(Patient patient, MedCenter medCenter){
        String email = patient.getEmail();
        String center = medCenter.getName();
        List<Appointment> appointments = this.appointmentRepository.findAll();
        for(Appointment app : appointments){
            if(app.getPatient()!=null) {
                if (app.getStart().isBefore(LocalDateTime.now()) && app.getPatient().getEmail().equals(email) &&
                        app.getMedCenter().getName().equals(center)) {
                    return true;
                }
            }
        }
        return false;
    }
}
