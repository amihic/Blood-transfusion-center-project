package com.example.ISA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.example.ISA.model.User;


@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private Environment env;

	public void sendTestMail(User newUser) {
		System.out.println("Slanje emaila za verifikaciju naloga...");
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(newUser.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		
		mail.setSubject("Verifikacija naloga");
        mail.setText("Zdravo " + newUser.getFirstName()
                + ",\n\nMolimo Vas da stisnete sledeći link kako biste verifikovali svoj nalog: \n"
                + "http://localhost:4200/verification" );
        javaMailSender.send(mail);
		
		System.out.println("Email poslat!");
		
	}

}
