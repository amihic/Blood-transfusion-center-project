package com.example.ISA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ISA.model.User;
import com.example.ISA.repository.UserRepository;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class UserService {

	 @Autowired
	 private UserRepository userRepository;
	
	  public User getUser(String email) {
	        return userRepository.findByEmail(email);
	    }
	  


	    //Izmena podataka  o Useru
	    public User UpdateUser(User u)
	    {
	        User editUser = userRepository.findByEmail(u.getEmail());

	       
	        editUser.setFirstName(u.getFirstName());
	        editUser.setLastName(u.getLastName());
	        editUser.setAddress(u.getAddress());
	        editUser.setCity(u.getCity());
	        editUser.setCountry(u.getCountry());
	        editUser.setGender(u.getGender());
	        editUser.setPassword(u.getPassword());
	        editUser.setEmail(u.getEmail());
	        editUser.setInfo(u.getInfo());
	        editUser.setJmbg(u.getJmbg());
	        editUser.setJob(u.getJob());
	        editUser.setPhoneNumber(u.getPhoneNumber());

	        return  this.userRepository.save(editUser);

	    }

	    public User save(User user) {
	        return userRepository.save(user);
	    }

}
