package com.example.ISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ISA.model.QuestionsForDonnor;

@Repository
public interface QuestionsForDonnorRepository extends JpaRepository<QuestionsForDonnor,String>{

}
