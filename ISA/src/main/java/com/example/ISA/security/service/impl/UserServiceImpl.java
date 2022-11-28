package com.example.ISA.security.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.ISA.DTO.UserRegistrationDTO;
import com.example.ISA.model.Authority;
import com.example.ISA.model.Patient;
import com.example.ISA.model.User;
import com.example.ISA.repository.UserRepository;
import com.example.ISA.security.service.UserAService;
import com.example.ISA.service.AuthorityService;
import com.example.ISA.service.PatientService;

@Service
public class UserServiceImpl implements UserAService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthorityService authorityService;
	
	@Autowired
	private PatientService patientService;


	@Override
	public User findByEmail(String email) throws UsernameNotFoundException {
		return userRepository.findByEmail(email);
	}

	public User findById(Long id) throws AccessDeniedException {
		return userRepository.findById(id).orElseGet(null);
	}

	public List<User> findAll() throws AccessDeniedException {
		return userRepository.findAll();
	}

	@Override
	public User save(UserRegistrationDTO userRegistrationDTO) {
		if(!userRegistrationDTO.getPassword1().equals(userRegistrationDTO.getPassword2())) {
			return null;
		}
		
		User u = new User();
		u.setEmail(userRegistrationDTO.getEmail());
		// pre nego sto postavimo lozinku u atribut hesiramo je kako bi se u bazi nalazila hesirana lozinka
		// treba voditi racuna da se koristi isi password encoder bean koji je postavljen u AUthenticationManager-u kako bi koristili isti algoritam
		u.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword1()));
		u.setFirstName(userRegistrationDTO.getFirstName());
		u.setLastName(userRegistrationDTO.getLastName());
		u.setEnabled(false);
		u.setAddress(userRegistrationDTO.getAddress());
		u.setCity(userRegistrationDTO.getCity());
		u.setCountry(userRegistrationDTO.getCountry());
		u.setPhoneNumber(userRegistrationDTO.getPhoneNumber());
		u.setJmbg(userRegistrationDTO.getJmbg());
		u.setGender(userRegistrationDTO.getGender());
		u.setJob(userRegistrationDTO.getJob());
		u.setInfo(userRegistrationDTO.getInfo());
		u.setRole("Patient");
		List<Authority> authorities=new ArrayList<>();
		
		Patient newPatient = new Patient();
		if(u.getRole().equalsIgnoreCase("Patient")) {
			authorities = authorityService.findByName("ROLE_PATIENT");
			u.setAuthorities(authorities);
			Patient patient = new Patient(u.getEmail(),u.getPassword(),u.getFirstName(),u.getLastName(),u.getAddress(),u.getCity(), u.getCountry(), u.getPhoneNumber(), u.getJmbg(), u.getGender(),u.getJob(), u.getInfo(),u.isEnabled(),u.getRole(),authorities);
			newPatient=this.patientService.save(patient);
			
		}
		System.out.println("Dodat pacijent");
		return u;
	}

}
