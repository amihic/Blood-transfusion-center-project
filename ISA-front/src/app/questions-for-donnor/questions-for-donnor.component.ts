import { Component, OnInit } from '@angular/core';
import { QuestionsForDonnor } from '../model/questionsForDonnor';
import { QuestionsForDonnorService } from '../service/questionsForDonnor.service';

@Component({
  selector: 'app-questions-for-donnor',
  templateUrl: './questions-for-donnor.component.html',
  styleUrls: ['./questions-for-donnor.component.css']
})
export class QuestionsForDonnorComponent implements OnInit {
  newRespondedQuestionsForDonnor:QuestionsForDonnor;
  allQuestionsForDonnor:QuestionsForDonnor[];
  pol = ['MALE', 'FEMALE'];
  answer = ['YES', 'NO'];

  constructor(private questionsForDonnorService:QuestionsForDonnorService) {
    this.newRespondedQuestionsForDonnor=new QuestionsForDonnor(
      {
        brojDavaoca:"",
        datum:"",
        prezimeRoditeljIme:"",
        jmbg:"",
        datumRodjenja:"",
        pol:"",
        adresa:"",
        opstina:"",
        mesto:"",
        kucniTel:"",
        poslovniTel:"",
        mobilniTel:"",
        preduzeceFakultetSkola:"",
        zanimanje:"",
        brojDavanja:0,
        potpis:"",


        q1:"",
        q2:"",
        q3:"",
        q4:"",
        q5:"",
        q6:"",
        q7:"",
        q8:"",
        q9:"",
        q10:"",
        q11:"",
        q12:"",
        q13:"",
        q14:"",
        q15:"",
        q16:"",
        q17:"",
        q18:"",
        q19:"",
        q20_a:"",
        q20_b:"",
        q20_c:"",
        q21:"",
        q22_a:"",
        q22_b:"",
        q22_c:"",
        q22_d:"",
        q22_e:"",
        q22_f:"",
        q22_g:"",
        q23_a:"",
        q23_b:"",
        q23_c:"",
        q23_d:"",
        q23_e:"",
        q23_f:"",

        q24:"",
        q25:"",
        q26:""
      }
    )
    this.allQuestionsForDonnor=[];
   }

  ngOnInit(): void {
  }

  reloadData()
  {
    this.questionsForDonnorService.getAllRespondedQuestionsForDonnor()
    .subscribe(res => this.allQuestionsForDonnor=res);
  }

  donate()
  {
    console.log(this.newRespondedQuestionsForDonnor)
    this.questionsForDonnorService.donate(this.newRespondedQuestionsForDonnor)
    .subscribe(_=>this.reloadData());
  }

}
