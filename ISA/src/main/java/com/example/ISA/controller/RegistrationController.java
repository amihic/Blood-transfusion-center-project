package com.example.ISA.controller;


import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ISA.DTO.UserRegistrationDTO;

import com.example.ISA.model.User;
import com.example.ISA.repository.RegistrationRepository;
import com.example.ISA.service.EmailService;
import com.example.ISA.service.RegistrationService;
import com.example.ISA.verification.VerificationToken;
import com.example.ISA.verification.VerificationTokenService;


@CrossOrigin("*")
@RestController
public class RegistrationController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private RegistrationRepository registrationRepository;
	
	@Autowired
	private VerificationTokenService verificationTokenService;
	
	//sacuvaj usera
	@RequestMapping(value="api/registration",method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> save(@RequestBody UserRegistrationDTO userDTO) throws Exception{	
		User newUser = this.registrationService.save(userDTO);
		VerificationToken verificationToken = new VerificationToken(String.valueOf(UUID.randomUUID()), newUser);
		this.verificationTokenService.save(verificationToken);
		try {
			emailService.sendTestMail(newUser,verificationToken);
		}
		catch( Exception e) {
			System.out.println(e.getMessage());
		}	
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}
	
	//vrati sve usere
	@RequestMapping(value="api/users",method = RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<User>> findAll(){
		List<User> users = this.registrationRepository.findAll();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	
	@PostMapping("/signup/async")
	public String signUpAsync(UserRegistrationDTO userRegistrationDTO){

		//slanje emaila
		try {
			System.out.println("Thread id: " + Thread.currentThread().getId());
			emailService.sendNotificaitionAsync(userRegistrationDTO);
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}

		return "success";
	}
	
	
	
	
	
	
}
