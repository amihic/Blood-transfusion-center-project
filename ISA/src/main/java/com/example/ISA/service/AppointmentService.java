package com.example.ISA.service;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.example.ISA.model.Appointment;
import com.example.ISA.model.Patient;
import com.example.ISA.model.QRCodeGenerator;
import com.example.ISA.repository.AppointmentRepository;
import com.example.ISA.repository.PatientRepository;

@Service
public class AppointmentService {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private Environment env;
	
	@Autowired
	private JavaMailSender javaMailSender;

	public Appointment save(Appointment appointment) {
		List<Appointment> appointments = this.appointmentRepository.findAll();
        int id=0;
        for ( Appointment ap:appointments) {
            id=ap.getId();
        }
        id=id+1;
        appointment.setId(id);
        appointment.setReserved(false);
       
		for(Appointment a:appointments) {
			if(appointment.getStart().isEqual(a.getStart()) &&
			    appointment.getStart().plusMinutes(30).isAfter(a.getStart()) &&
		   	    appointment.getStart().isBefore(a.getStart().plusMinutes(30)) ||
		   	    appointment.getStart().isBefore(LocalDateTime.now()))
				{
					System.out.println("Zauzet termin ili su datum i vreme u proslom vremenu");
					return null;
				}
		}
			return this.appointmentRepository.save(appointment);
	}

	public Appointment cancelAppointment(int patient_id, Appointment appointment) {
		
		if(!LocalDateTime.now().isAfter(appointment.getStart().minusHours(24))) {
			if(appointment.getPatient().getId()==patient_id){
				appointment.setReserved(false);
				appointment.setPatient(null);
				System.out.println("Termin otkazan");
				return this.appointmentRepository.save(appointment);
			}
		}
		System.out.println("Ostalo je manje od 24h do termina. Otkazivanje nije moguce. / Pacijent moze samo svoj termin da otkazes.");
		return null;
		
		
		
		/*List<Appointment> appointments = this.appointmentRepository.findAll();
		try {
		for(Appointment app:appointments) {
			if(!LocalDateTime.now().isAfter(app.getStart().minusHours(24))) {
				if(app.getPatient().getId()==patient_id) {
					if(app.isReserved()) {
					app.setReserved(false);
					System.out.println("Termin otkazan");
					return this.appointmentRepository.save(app);
					}
				}
			}
		}
		}catch(Exception e) {
			System.out.println("Ostalo je manje od 24h do termina. Otkazivanje nije moguce");
			return null;
		}
		System.out.println("Ne postoji");
		return null;*/
	}

	public Appointment reserveAppointment(int patient_id, Appointment appointment) throws Exception {
		List<Appointment> appointments = this.appointmentRepository.findAll();
		List<Patient> patients = this.patientRepository.findAll();
		//Patient patient = new Patient();
		
		for(Patient pat:patients) {
		for(Appointment app:appointments) {
			if(pat.getId()==patient_id && !app.isReserved() && appointment.getStart().equals(app.getStart())) {
				if(pat.getQfd()!=null && pat.getQfd().getDatum().isBefore(appointment.getStart().minusMonths(6))) {
					app.setReserved(true);
					app.setPatient(pat);
					sendAcceptingMail(app);
					return this.appointmentRepository.save(app);
					}
				}
			}	
		}
		System.out.println("Termin je zauzet ili pacijenta nema u bazi ili je pacijent donirao krv u proteklih 6 meseci ili nije popunio upitnik");
		return null;
	}

	
	
	public void sendAcceptingMail(Appointment appointment) throws Exception{
		
		System.out.println("Slanje emaila za obavestenje o rezervaciji termina...");
		String subject = "Rezervacija termina davanja krvi";
		String text = "Zdravo " + appointment.getPatient().getFirstName() 
				+ ",\n\nUspešno ste rezervisali termin za davanje krvi. Ovo su informacije o terminu:"
				+ "\nDatum i vreme: " + appointment.getStart().toLocalDate() + " u " + appointment.getStart().toLocalTime() +" časova."
				+ "\nTrajanje: " + appointment.getDuration() + " minuta"
				+ "\n\n Vidimo se!";
		String body = "QR kod za rezervaciju:";
		String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode.png";
		QRCodeGenerator.generateQRCodeImage(text, 350, 350, QR_CODE_IMAGE_PATH);
		sendMailWithAttachment(appointment.getPatient().getEmail(), body, subject, QR_CODE_IMAGE_PATH);
	}

	public void sendMailWithAttachment(String toEmail, String body, String subject, String attachment) throws MessagingException {
		MimeMessage mimeMessage=javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
		mimeMessageHelper.setFrom(env.getProperty("spring.mail.username"));
		mimeMessageHelper.setTo(toEmail);
		mimeMessageHelper.setText(body);
		mimeMessageHelper.setSubject(subject);
		
		FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));
		mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),
		fileSystemResource);
		javaMailSender.send(mimeMessage);
		System.out.println("Email poslat!");
	}

/*
public void sendAcceptingMail(Appointment appointment) {
	
	System.out.println("Slanje emaila za obavestenje o rezervaciji termina...");
	SimpleMailMessage mail = new SimpleMailMessage();
	mail.setTo(appointment.getPatient().getEmail());
	mail.setFrom(env.getProperty("spring.mail.username"));
	mail.setSubject("Rezervacija termina za davanje krvi");
    mail.setText("Zdravo " + appointment.getPatient().getFirstName()
            + ",\n\nUspešno ste rezervisali termin za davanje krvi. Ovo su informacije o terminu:"
            + "\nDatum i vreme: " + appointment.getStart().toLocalDate() + " u " + appointment.getStart().toLocalTime() +" časova."
            + "\nTrajanje: " + appointment.getDuration() + " minuta" 
          
            + "\n\n Vidimo se!"
            );
    javaMailSender.send(mail);
	
	System.out.println("Email poslat!");
}*/






}
