import { Component, OnInit } from '@angular/core';
import { Profile } from '../model/profile';
import { ProfileService } from '../service/profile.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  profile:Profile;
  tEmail:string;

  constructor(private profileService:ProfileService) { 
    this.tEmail = "";
    this.profile= new Profile
    ({
      user:
      ({
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
      }),
      category:"",
      points: 0
    })
    
  }

  ngOnInit(): void {
    this.getProfile();
  }

  getProfile()
  {
    this.tEmail =  String(sessionStorage.getItem('email'))
    this.profileService.getProfile(this.tEmail)
    .subscribe((res: Profile) => this.profile=res);
  }

}
