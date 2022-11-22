import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class VerificationService 
{
  url="http://localhost:8080/api/verification";


  constructor(private http:HttpClient) {}
   
  verify():Observable<User[]>
  {
    return this.http.get<User[]>(this.url);
  }
  



}