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

import com.example.ISA.model.User;
import com.example.ISA.repository.RegistrationRepository;
import com.example.ISA.service.RegistrationService;

@RestController
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private RegistrationRepository registrationRepository;
	
	//sacuvaj usera
	@RequestMapping(value="api/registration",method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> save(@RequestBody User user) throws Exception{
		User newUser = this.registrationService.save(user);
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}
	
	//vrati sve usere
	@RequestMapping(value="api/users",method = RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<User>> findAll(){
		List<User> users = this.registrationRepository.findAll();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
}
