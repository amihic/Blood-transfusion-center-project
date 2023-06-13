import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from '../model/user';
import { RegistrationComponent } from '../registration/registration.component';
import { RegistrationService } from '../service/registration.service';

@Component({
  selector: 'app-verification',
  templateUrl: './verification.component.html',
  styleUrls: ['./verification.component.css']
})
export class VerificationComponent implements OnInit {

  verifiedUser:User;

  constructor(private registrationService:RegistrationService) {
    this.verifiedUser = new User
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
          gender:"male",
          job:"",
          info:"",
          isActivated:false,
          penalties:0

        }
      );
  }



  ngOnInit(): void {
  }

  verify(){
    this.registrationService.verify(this.verifiedUser)
    .subscribe((res: User) => this.verifiedUser=res)
  }

}
