package com.example.ISA.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.ISA.model.Appointment;
import com.example.ISA.repository.AppointmentRepository;
import com.example.ISA.service.AppointmentService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Appointment>> getAll(){
		List<Appointment> appointments = this.appointmentRepository.findAll();
		return new ResponseEntity<>(appointments, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
	//@PreAuthorize("hasRole('ADMIN_EMPLOYEE')")
	public ResponseEntity<Appointment> save(@RequestBody Appointment appointment){
		Appointment newAppointment = this.appointmentService.save(appointment);
		return new ResponseEntity<>(newAppointment, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/visitingHistory/{email}", method = RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	//@PreAuthorize("hasRole('PATIENT')")
	public ResponseEntity<List<Appointment>> visitingHistory(@PathVariable String email){
		List<Appointment> visited = this.appointmentService.findVisitingHistory(email);
		return new ResponseEntity<>(visited, HttpStatus.OK);
	}

	@RequestMapping(value = "/visitingHistoryByDate/{email}", method = RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	//@PreAuthorize("hasRole('PATIENT')")
	public ResponseEntity<List<Appointment>> visitingHistoryByDate(@PathVariable String email){
		List<Appointment> visitedByDate = this.appointmentService.findVisitingHistoryByDate(email);
		return new ResponseEntity<>(visitedByDate, HttpStatus.OK);
	}

	@RequestMapping(value = "/futureApps/{email}", method = RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	//@PreAuthorize("hasRole('PATIENT')")
	public ResponseEntity<List<Appointment>> futureApps(@PathVariable String email){
		List<Appointment> visited = this.appointmentService.findFutureApps(email);
		return new ResponseEntity<>(visited, HttpStatus.OK);
	}

	@RequestMapping(value = "/futureAppsByDate/{email}", method = RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	//@PreAuthorize("hasRole('PATIENT')")
	public ResponseEntity<List<Appointment>> futureAppointmentsByDate(@PathVariable String email){
		List<Appointment> visitedByDate = this.appointmentService.findFutureAppointmentsByDate(email);
		return new ResponseEntity<>(visitedByDate, HttpStatus.OK);
	}

	@RequestMapping(value = "/allByDateTime", method = RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	//@PreAuthorize("hasRole('PATIENT')")
	public ResponseEntity<List<Appointment>> orderByDateTime(){
		List<Appointment> appointments = this.appointmentRepository.findByOrderByStart();
		return new ResponseEntity<>(appointments, HttpStatus.OK);
	}
	
	@PutMapping(value="/cancel/{email}")
	public ResponseEntity<Appointment> cancel(@PathVariable String email, @RequestBody Appointment appointment){
		Appointment canceledAppointment = this.appointmentService.cancelAppointment(email, appointment);
		return new ResponseEntity<>(canceledAppointment, HttpStatus.OK);
	}
	
	
	@PutMapping(value="/reserve/{email}")
	public ResponseEntity<Appointment> reserve(@PathVariable String email, @RequestBody Appointment appointment) throws Exception{
		Appointment reservedAppointment = this.appointmentService.reserveAppointment(email, appointment);
		return new ResponseEntity<>(reservedAppointment, HttpStatus.OK);
	}

	
	
}
