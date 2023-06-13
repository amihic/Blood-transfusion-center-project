import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Complaint } from "../model/complaint";
import { MedCenter } from "../model/medCenter";


@Injectable({
    providedIn: 'root'
  })
  export class ComplaintService 
  {
    url = "http://localhost:8080/api/complaint";
     
    constructor(private http:HttpClient) {}

    //reserveAppointment(tEmail:String, appointment:Appointment)
    //{
    //  return this.http.put<Appointment>(`${this.reserve_url}/` + `${tEmail}`, appointment);
    //}

    sendComplaintByEmail(tEmail:String, newComplaint:Complaint, medCenter:String){
        return this.http.post<Complaint>(`${this.url}/` + `${tEmail}/` + `${medCenter}`, newComplaint);
    }
    
  
  }