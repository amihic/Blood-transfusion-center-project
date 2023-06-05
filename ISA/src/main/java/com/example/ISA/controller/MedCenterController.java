package com.example.ISA.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ISA.model.MedCenter;
import com.example.ISA.model.Rating;
import com.example.ISA.repository.MedCenterRepository;
import com.example.ISA.service.MedCenterService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/medCenter")
public class MedCenterController {

	@Autowired
	private MedCenterService medCenterService;
	
	@Autowired
	private MedCenterRepository medCenterRepository;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<MedCenter>> getAll(){
	List<MedCenter> all = this.medCenterRepository.findAll();
			
			for(MedCenter mc:all) {
				
				try {
				List<Rating> rates= (List<Rating>) mc.getRating();
				
				double val = 0;
	
				for(Rating r : rates) {
					val+=r.getGrade();
				}
				val= val/rates.size();
				
				mc.setAvgRate(val);
				this.medCenterRepository.save(mc);
				}catch(NullPointerException e) {}
			}
		List<MedCenter> medCenters = this.medCenterRepository.findAll();
		return new ResponseEntity<>(medCenters, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/allByName", method = RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('PATIENT')")
	public ResponseEntity<List<MedCenter>> orderByName(){
		List<MedCenter> medCenters = this.medCenterRepository.findByOrderByName();
		return new ResponseEntity<>(medCenters, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/allByCity", method = RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('PATIENT')")
	public ResponseEntity<List<MedCenter>> orderByCity(){
		List<MedCenter> medCenters = this.medCenterRepository.findByOrderByCity();
		return new ResponseEntity<>(medCenters, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{name}",method = RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<MedCenter> getByName(@PathVariable String name){
		MedCenter medCenter = this.medCenterRepository.getByName(name);
        return new ResponseEntity<>(medCenter, HttpStatus.OK);
    }
	
	@RequestMapping(value="/{city}",method = RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<MedCenter> getByCity(@PathVariable String city){
		MedCenter medCenter = this.medCenterRepository.getByCity(city);
        return new ResponseEntity<>(medCenter, HttpStatus.OK);
    }
	
	//cela logika u ovoj metodi je verovatno nepotrebna jer je implementirana u 
	//getAll metodi koja se automatski pokrene pri otvaranju stranice http://localhost:8080/api/medCenter/all"
	@RequestMapping(value = "/allByRating", method = RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	//@PreAuthorize("hasRole('PATIENT')")
	public ResponseEntity<List<MedCenter>> orderByRating(){
		
		List<MedCenter> all = this.medCenterRepository.findAll();
		
		for(MedCenter mc:all) {
			
			try {
			List<Rating> rates= (List<Rating>) mc.getRating();
			
			double val = 0;

			for(Rating r : rates) {
				val+=r.getGrade();
			}
			val= val/rates.size();
			
			mc.setAvgRate(val);
			this.medCenterRepository.save(mc);
			}catch(NullPointerException e) {}
		}
		List<MedCenter> medCenters = this.medCenterRepository.findByOrderByAvgRateDesc();
		return new ResponseEntity<>(medCenters, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MedCenter> save(@RequestBody MedCenter medCenter){
		MedCenter newMedCenter = this.medCenterService.save(medCenter);
		return new ResponseEntity<>(newMedCenter, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MedCenter> update(@RequestBody MedCenter medCenter){
		MedCenter updatedMedCenter = this.medCenterService.update(medCenter);
		return new ResponseEntity<>(updatedMedCenter, HttpStatus.CREATED);
	}
	
	
	
}
