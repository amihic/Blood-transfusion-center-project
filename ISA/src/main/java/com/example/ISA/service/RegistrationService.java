package com.example.ISA.service;

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

	public User verify(UserRegistrationDTO userDTO) {
		try {
		User verifiedUser = registrationRepository.getByEmail(userDTO.getEmail());   
		verifiedUser.setEnabled(true);
		registrationRepository.save(verifiedUser);
		sendAcceptingMail(verifiedUser);
		return verifiedUser;
		}catch(Exception e){}
		return null;
	}
	
	public void sendAcceptingMail(User verifiedUser) {
		
		System.out.println("Slanje emaila za obavestenje o uspesnoj verifikaciji...");
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
