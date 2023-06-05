package com.example.ISA.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.ISA.DTO.UserRegistrationDTO;
import com.example.ISA.model.User;
import com.example.ISA.repository.RegistrationRepository;
import com.example.ISA.service.RegistrationService;



@CrossOrigin("*")
@RestController
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private RegistrationRepository registrationRepository;
	
	//verifikacija usera
	@RequestMapping(value="api/verification" ,method = RequestMethod.PUT, consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> verify(@RequestBody UserRegistrationDTO userDTO){
		User verifiedUser = this.registrationService.verify(userDTO);
		return new ResponseEntity<>(verifiedUser, HttpStatus.OK);
	}
	
	//vrati sve usere
	@RequestMapping(value="api/users",method = RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<User>> findAll(){
		try {
		List<User> users = this.registrationRepository.findAll();
		return new ResponseEntity<>(users, HttpStatus.OK);
		}catch(Exception e) {}
		return null;
	}
	
}
