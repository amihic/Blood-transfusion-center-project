package com.example.ISA.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ISA.model.Appointment;
import com.example.ISA.repository.AppointmentRepository;

@Service
public class AppointmentService {
	
	@Autowired
	private AppointmentRepository appointmentRepository;

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

	public Appointment cancelAppointment(Long patient_id) {
		
		List<Appointment> appointments = this.appointmentRepository.findAll();
		try {
		for(Appointment app:appointments) {
			if(!LocalDateTime.now().isAfter(app.getStart().minusHours(24))) {
				if(app.getPatient().getId()==patient_id) {
					app.setReserved(false);
					System.out.println("Termin otkazan");
					return this.appointmentRepository.save(app);	
				}
			}
		}
		}catch(Exception e) {
			System.out.println("Ostalo je manje od 24h do termina. Otkazivanje nije moguce");
			return null;
		}
		System.out.println("Ne postoji");
		return null;
	}

	public Appointment reserveAppointment(Long patient_id) {
		
		//email
		return null;
	}



}
