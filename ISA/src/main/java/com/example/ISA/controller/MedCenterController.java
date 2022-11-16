package com.example.ISA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ISA.model.MedCenter;
import com.example.ISA.model.Rating;
import com.example.ISA.repository.MedCenterRepository;
import com.example.ISA.service.MedCenterService;

@RestController
@RequestMapping("/api/medCenter")
public class MedCenterController {

	@Autowired
	private MedCenterService medCenterService;
	
	@Autowired
	private MedCenterRepository medCenterRepository;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<MedCenter>> getAll(){
		List<MedCenter> medCenters = this.medCenterRepository.findAll();
		return new ResponseEntity<>(medCenters, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/allByName", method = RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<MedCenter>> orderByName(){
		List<MedCenter> medCenters = this.medCenterRepository.findByOrderByName();
		return new ResponseEntity<>(medCenters, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/allByCity", method = RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<MedCenter>> orderByCity(){
		List<MedCenter> medCenters = this.medCenterRepository.findByOrderByCity();
		return new ResponseEntity<>(medCenters, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/allByRating", method = RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<MedCenter>> orderByRating(){
		List<MedCenter> medCenters = this.medCenterRepository.findByOrderByRating();
		return new ResponseEntity<>(medCenters, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MedCenter> save(@RequestBody MedCenter medCenter){
		MedCenter newMedCenter = this.medCenterService.save(medCenter);
		return new ResponseEntity<>(newMedCenter, HttpStatus.CREATED);
	}
	
	
	
	
}
