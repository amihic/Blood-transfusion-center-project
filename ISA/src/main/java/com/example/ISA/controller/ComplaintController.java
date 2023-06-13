package com.example.ISA.controller;

import com.example.ISA.model.Complaint;
import com.example.ISA.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ISA.repository.ComplaintRepository;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/complaint")
public class ComplaintController {
    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private ComplaintService complaintService;

    @RequestMapping(value ="/{email}/{medCenter}", method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Complaint> createComplaint(@PathVariable String email, @PathVariable String medCenter, @RequestBody Complaint complaint){
        Complaint newComplaint = this.complaintService.save(email, complaint, medCenter);
        return new ResponseEntity<>(newComplaint, HttpStatus.CREATED);
    }




}
