package com.example.ISA.service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.ISA.DTO.UserRegistrationDTO;
import com.example.ISA.model.User;
import com.example.ISA.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository registrationRepository;
	
	@Autowired
	private Environment env;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void checkPassword(String pw1, String pw2) {
		if(!pw1.equals(pw2)) {
			return;
		}
	}
	
	
	public User save(UserRegistrationDTO userDTO) throws Exception{
		List<User> users = this.registrationRepository.findAll();
		for(User u:users) {
			if(userDTO.getEmail().equals(u.getEmail())) {
				return null;
			}
		}
		
        List<User> listOfAll = this.registrationRepository.findAll();
        int id=0;
        for ( User u:listOfAll) {
            id=u.getId();
        }
        id=id+1;
        userDTO.setId(id);
        
        if(!userDTO.getPassword1().equals(userDTO.getPassword2())){
        	return null;
        }
        
        User user = new User();
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword1());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setAddress(userDTO.getAddress());
        user.setCity(userDTO.getCity());
        user.setCountry(userDTO.getCountry());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setJmbg(userDTO.getJmbg());
        user.setGender(userDTO.getGender());
        user.setJob(userDTO.getJob());
        user.setInfo(userDTO.getInfo());
        
        return this.registrationRepository.save(user);
	}


	public User verify(UserRegistrationDTO userDTO) {
		try {
		User verifiedUser = registrationRepository.getByEmail(userDTO.getEmail());   
		verifiedUser.setActivated(true);
		registrationRepository.save(verifiedUser);
		sendAcceptingMail(verifiedUser);
		return verifiedUser;
		}catch(Exception e){}
		return null;
	}
	
	public void sendAcceptingMail(User verifiedUser) {
		
		System.out.println("Slanje emaila...");
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(verifiedUser.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		
		mail.setSubject("Uspešna verifikacija naloga");
        mail.setText("Zdravo " + verifiedUser.getFirstName()
                + ",\n\nUspešno ste registrovani u naš sistem. Sada se možete ulogovati.");
        javaMailSender.send(mail);
		
		System.out.println("Email poslat!");
	}
	
	
}
