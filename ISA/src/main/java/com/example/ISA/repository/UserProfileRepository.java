package com.example.ISA.repository;

import com.example.ISA.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<Profile, Long> {

}
