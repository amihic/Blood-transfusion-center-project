package com.example.ISA.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ISA.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}