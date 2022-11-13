import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { RegistrationService } from '../service/registration.service';



@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  genders = ['MALE', 'FEMALE'];
  newUser:User;
  users:User[];


  constructor(private registrationService:RegistrationService) {
    this.newUser = new User
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
          gender:"",
          job:"",
          info:""

        }
      );
     this.users=[]; 

   }



  ngOnInit(): void {
  }

  reloadData()
  {
    this.registrationService.getUsers()
    .subscribe(res => this.users=res);
  }

  registration()
  {
    console.log(this.newUser)
    this.registrationService.registration(this.newUser)
    .subscribe(_=>this.reloadData());
  }
  
  


}
