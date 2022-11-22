package com.example.ISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ISA.DTO.UserRegistrationDTO;

import com.example.ISA.model.User;


@Repository
public interface RegistrationRepository extends JpaRepository<User,String> {

	UserRegistrationDTO save(UserRegistrationDTO userDTO);

	User getByEmail(String email);

}
