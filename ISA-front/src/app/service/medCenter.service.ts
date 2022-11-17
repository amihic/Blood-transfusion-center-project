import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MedCenter } from '../model/medCenter';


@Injectable({
  providedIn: 'root'
})
export class MedCenterService 
{
  //url0 = "http://localhost:8080/api/home";
  url1 = "http://localhost:8080/api/medCenter/all";
  url2 = "http://localhost:8080/api/medCenter/allByName";
  url3 = "http://localhost:8080/api/medCenter/allByCity";
  url4 = "http://localhost:8080/api/medCenter/allByRating";

  constructor(private http:HttpClient) {}

  
  getMedCenters():Observable<MedCenter[]>
  {
    return this.http.get<MedCenter[]>(this.url1);
  }

  getMedCentersByName():Observable<MedCenter[]>
  {
    return this.http.get<MedCenter[]>(this.url2);
  }

  getMedCentersByCity():Observable<MedCenter[]>
  {
    return this.http.get<MedCenter[]>(this.url3);
  }

  getMedCentersByRating():Observable<MedCenter[]>
  {
    return this.http.get<MedCenter[]>(this.url4);
  }
  /*
  saveMedCenter(newUser:MedCenter):Observable<MedCenter>
  {
    
    return this.http.post<MedCenter>(this.url,newMedCenter);
  }*/


}