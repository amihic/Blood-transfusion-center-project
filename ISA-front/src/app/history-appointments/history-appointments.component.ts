import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Appointment } from '../model/appointment';
import { User } from '../model/user';
import { AppointmentService } from '../service/appointment.service';
import moment from 'moment';

@Component({
  selector: 'app-history-appointments',
  templateUrl: './history-appointments.component.html',
  styleUrls: ['./history-appointments.component.css']
})
export class HistoryAppointmentsComponent implements OnInit {

  appointments:Appointment[];
  appointment:Appointment;
  tEmail:String;
  user:User;
  patientId = 0;

  constructor(private route: ActivatedRoute, private appointmentService:AppointmentService) {
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
          medCenter:({
            id: 1,
              name:"",
              street:"",
              city:"",
              country:"",
              avgRate:0,
              description:""
          }),
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
            //bloodType:"",
            //points:0,
            //penalties:0,
            //category:"",
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
          isActivated:false,
          penalties:0

        }
      );
   }

   formatDate(dateString: string): string {
    const momentDate = moment(dateString);
    return momentDate.format('DD.MM.YYYY HH:mm');
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
    this.tEmail =  String(sessionStorage.getItem('email'))
    this.appointmentService.getIndividualHistoryAppointmentsByDateAndTime(this.tEmail)
    .subscribe((res: Appointment[]) => this.appointments=res);
  }

  
}
