import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Profile } from "../model/profile";

@Injectable({
    providedIn: 'root'
  })
  export class ProfileService 
  {
    url = "http://localhost:8080/api/profile";
     
    constructor(private http:HttpClient) {}
  
    getProfile(tEmail:String):Observable<Profile>
    {
        return this.http.get<Profile>(`${this.url}/${tEmail}`);
    }
    
  
  }