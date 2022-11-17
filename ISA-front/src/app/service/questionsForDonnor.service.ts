import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { QuestionsForDonnor } from '../model/questionsForDonnor';


@Injectable({
  providedIn: 'root'
})
export class QuestionsForDonnorService 
{
  //url0 = "http://localhost:8080/api/home";
  url1 = "http://localhost:8080/api/QuestionsForDonnor";
  url2 = "http://localhost:8080/api/QuestionsForDonnor/all";
  

  constructor(private http:HttpClient) {}

  
  getAllRespondedQuestionsForDonnor():Observable<QuestionsForDonnor[]>
  {
    return this.http.get<QuestionsForDonnor[]>(this.url2);
  }

  donate(newRespondedQuestionsForDonnor:QuestionsForDonnor):Observable<QuestionsForDonnor>
  {
    
    return this.http.post<QuestionsForDonnor>(this.url1,newRespondedQuestionsForDonnor);
  }
  
  


}


