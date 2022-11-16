package com.example.ISA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ISA.DTO.UserRegistrationDTO;
import com.example.ISA.model.MedCenter;
import com.example.ISA.model.Rating;
import com.example.ISA.model.User;
import com.example.ISA.repository.MedCenterRepository;

@Service
public class MedCenterService {

	@Autowired
	private MedCenterRepository medCenterRepository;

	public MedCenter save(MedCenter medCenter) {
			
	        List<MedCenter> listOfAll = this.medCenterRepository.findAll();
	        int id=0;
	        for ( MedCenter mc:listOfAll) {
	            id=mc.getId();
	        }
	        id=id+1;
	        medCenter.setId(id);
	        
	        return this.medCenterRepository.save(medCenter);	
	}
	
	
	
	
	
}
