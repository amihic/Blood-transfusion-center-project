package com.example.ISA.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ISA.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}