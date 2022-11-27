import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService 
{
  url="http://localhost:8080/api/registration";
  url1 = "http://localhost:8080/api/users";
  url2 = "http://localhost:8080/api/verification";

  constructor(private http:HttpClient) {}
   
  getUsers():Observable<User[]>
  {
    return this.http.get<User[]>(this.url1);
  }
  
  registration(newUser:User):Observable<User>
  {
    return this.http.post<User>(this.url,newUser);
  }

  verify(verifiedUser:User):Observable<User>
  {
    return this.http.put<User>(this.url2,verifiedUser);
  }


}