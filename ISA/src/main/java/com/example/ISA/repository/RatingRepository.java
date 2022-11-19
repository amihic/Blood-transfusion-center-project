package com.example.ISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.ISA.model.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating,String>{

}
