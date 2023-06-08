package com.example.ISA.service;

import com.example.ISA.model.Appointment;
import com.example.ISA.model.Complaint;
import com.example.ISA.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    public Complaint save(Complaint complaint) {
        List<Complaint> complaints = this.complaintRepository.findAll();
        int id=0;
        for ( Complaint c:complaints) {
            id=c.getId();
        }
        id=id+1;
        complaint.setId(id);
        return this.complaintRepository.save(complaint);
    }
}
