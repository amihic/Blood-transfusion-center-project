package com.example.ISA.security.service;

import java.util.List;

import com.example.ISA.model.Role;



public interface RoleService {
	Role findById(Long id);
	List<Role> findByName(String name);
}
