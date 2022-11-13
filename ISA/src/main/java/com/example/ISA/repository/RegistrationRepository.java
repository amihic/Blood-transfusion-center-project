package com.example.ISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ISA.model.User;



public interface RegistrationRepository extends JpaRepository<User,String> {

}
