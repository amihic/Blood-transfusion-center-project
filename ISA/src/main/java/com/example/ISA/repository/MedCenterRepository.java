package com.example.ISA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ISA.model.MedCenter;
import com.example.ISA.model.Rating;


public interface MedCenterRepository extends JpaRepository<MedCenter,String> {

	List<MedCenter> findByOrderByName();

	List<MedCenter> findByOrderByCity();

	List<MedCenter> findByOrderByRating();

	List<MedCenter> findByOrderByAvgRate();

	List<MedCenter> findByOrderByAvgRateDesc();

	MedCenter getByName(String name);
	
	MedCenter getByCity(String city);

	MedCenter getByAvgRate(Double avgRate);
	
}
