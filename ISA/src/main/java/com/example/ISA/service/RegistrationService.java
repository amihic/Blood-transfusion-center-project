package com.example.ISA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ISA.model.User;
import com.example.ISA.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository registrationRepository;
	
	
	public User save(User user) throws Exception{
		return this.registrationRepository.save(user);
	}
	
	
}
