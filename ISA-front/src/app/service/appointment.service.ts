import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Appointment } from "../model/appointment";

@Injectable({
    providedIn: 'root'
  })
  export class AppointmentService 
  {
    url = "http://localhost:8080/api/appointment/all";
    cancel_url = "http://localhost:8080/api/appointment/cancel";
    reserve_url = "http://localhost:8080/api/appointment/reserve";
    sortByDateTime_url = "http://localhost:8080/api/appointment/allByDateTime";
    constructor(private http:HttpClient) {}
  
    getAllAppointments():Observable<Appointment[]>
    {
      return this.http.get<Appointment[]>(this.url);
    }
    getAllAppointmentsByDateAndTime()
    {
        return this.http.get<Appointment[]>(this.sortByDateTime_url);
    }
    
    cancelAppointment(id:number, appointment:Appointment)
    {
      return this.http.put<Appointment>(`${this.cancel_url}/` + `${id}`, appointment);
      
    }

    reserveAppointment(id:number, appointment:Appointment)
    {
        return this.http.put<Appointment>(`${this.reserve_url}/` + `${id}`, appointment);
    }
  
  }