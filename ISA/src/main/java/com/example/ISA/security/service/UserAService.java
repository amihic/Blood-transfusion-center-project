package com.example.ISA.security.service;

import java.util.List;

import com.example.ISA.DTO.UserRegistrationDTO;
import com.example.ISA.model.User;


public interface UserAService {
    User findById(Long id);
    User findByEmail(String username);
    List<User> findAll ();
	User save(UserRegistrationDTO userRegistrationDTO);
}
