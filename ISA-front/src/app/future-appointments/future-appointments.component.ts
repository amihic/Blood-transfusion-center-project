import { Component, OnInit } from '@angular/core';
import { Appointment } from '../model/appointment';
import { User } from '../model/user';
import { AppointmentService } from '../service/appointment.service';

@Component({
  selector: 'app-future-appointments',
  templateUrl: './future-appointments.component.html',
  styleUrls: ['./future-appointments.component.css']
})
export class FutureAppointmentsComponent implements OnInit {

  appointments:Appointment[];
  appointment:Appointment;
  tEmail:String;
  user:User;
  patientId = 0;

  constructor(private appointmentService:AppointmentService) {
    this.appointments=[];
    this.tEmail = '';
    this.appointment = new Appointment
      (
        {
          id: 1,
          start: "",
          duration:30,
          deleted: false,
          reserved: false,
          patient: ({
            id:1,
            email:"",
            password1:"",
            password2:"",
            firstName:"",
            lastName:"",
            address:"",
            city:"",
            country:"",
            phoneNumber:"",
            jmbg:"",
            gender:"",
            job:"",
            info:"",
            isActivated:true,
          })
          

        }
      );
      this.user = new User
      (
        {
          id: 1,
          email: "",
          password1:"",
          password2:"",
          firstName:"",
          lastName: "",
          address:"",
          city:"",
          country:"",
          phoneNumber:"",
          jmbg: "",
          gender:"male",
          job:"",
          info:"",
          isActivated:false

        }
      );
   }

  ngOnInit(): void {
    this.getAppointments();
  }

  getAppointments()
  {
    this.tEmail =  String(sessionStorage.getItem('email'))
    this.appointmentService.getIndividualHistoryAppointments(this.tEmail)
    .subscribe((res: Appointment[]) => this.appointments=res);
  }

  getAppointmentsByDateAndTime()
  {
    this.appointmentService.getIndividualAllAppointmentsByDateAndTime()
    .subscribe((res: Appointment[]) => this.appointments=res);
  }

  cancelReservation(id:number, appointment:Appointment)
  {
    //this.appointmentService.cancelAppointment(id, appointment)
    //.subscribe((res: Appointment) => this.appointment=res);
    //window.location.reload();
  }

}
