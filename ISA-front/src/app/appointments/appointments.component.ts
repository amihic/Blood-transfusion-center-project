import { Component, OnInit } from '@angular/core';
import { Appointment } from '../model/appointment';
import { User } from '../model/user';
import { AppointmentService } from '../service/appointment.service';


@Component({
  selector: 'app-appointments',
  templateUrl: './appointments.component.html',
  styleUrls: ['./appointments.component.css']
})
export class AppointmentsComponent implements OnInit {
  appointments:Appointment[];
  appointment:Appointment;
  user:User;
  patientId = 0;
  tEmail:String;

  constructor(private appointmentService:AppointmentService) {
    this.appointments=[];
    this.tEmail = "";
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
    this.appointmentService.getAllAppointments()
    .subscribe((res: Appointment[]) => this.appointments=res);
  }

  getAppointmentsByDateAndTime()
  {
    this.appointmentService.getAllAppointmentsByDateAndTime()
    .subscribe((res: Appointment[]) => this.appointments=res);
  }

  reserve(appointment:Appointment)
  {
    this.tEmail =  String(sessionStorage.getItem('email'))
    this.appointmentService.reserveAppointment(this.tEmail, appointment)
    .subscribe((res: Appointment) => this.appointment=res);
    window.location.reload();
  }

  cancelReservation(appointment:Appointment)
  {
    this.tEmail =  String(sessionStorage.getItem('email'))
    this.appointmentService.cancelAppointment(this.tEmail, appointment)
    .subscribe((res: Appointment) => this.appointment=res);
    window.location.reload();
  }
}
