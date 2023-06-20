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
    individualUrl = "http://localhost:8080/api/appointment/futureApps/${encodeURIComponent(email)}";

    historyUrl = "http://localhost:8080/api/appointment/visitingHistory";
    historyByDateUrl = "http://localhost:8080/api/appointment/visitingHistoryByDate";
    futureUrl = "http://localhost:8080/api/appointment/futureApps";
    futureByDateUrl = "http://localhost:8080/api/appointment/futureAppsByDate";

    individualSortByDateTime_url = "http://localhost:8080/api/appointment/{email}/allByDateTime";
    constructor(private http:HttpClient) {}
  
    getAllAppointments():Observable<Appointment[]>
    {
      return this.http.get<Appointment[]>(this.url);
    }
    getAllAppointmentsByDateAndTime()
    {
        return this.http.get<Appointment[]>(this.sortByDateTime_url);
    }

    getIndividualHistoryAppointmentsByDateAndTime(tEmail:String)
    {
        return this.http.get<Appointment[]>(`${this.historyByDateUrl}/${tEmail}`);
    }

    getIndividualFutureAppointmentsByDateAndTime(tEmail:String)
    {
        return this.http.get<Appointment[]>(`${this.futureByDateUrl}/${tEmail}`);
    }

    getIndividualHistoryAppointments(tEmail:String)
    {
        return this.http.get<Appointment[]>(`${this.historyUrl}/${tEmail}`);
    }

    getIndividualFutureAppointments(tEmail:String)
    {
        return this.http.get<Appointment[]>(`${this.futureUrl}/${tEmail}`);
    }
    
    cancelAppointment(tEmail:String, appointment:Appointment)
    {
      return this.http.put<Appointment>(`${this.cancel_url}/` + `${tEmail}`, appointment);
    }

    reserveAppointment(tEmail:String, appointment:Appointment)
    {
      return this.http.put<Appointment>(`${this.reserve_url}/` + `${tEmail}`, appointment);
    }
  
  }