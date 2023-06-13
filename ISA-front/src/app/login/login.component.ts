import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  
  email: any;
  password = '';
  invalidLogin = false;
  error:string='';
  idLoginUser:any;

  @Output()
  LogIn: EventEmitter<void> = new EventEmitter();


  constructor(private router: Router,private loginservice: AuthenticationService) { }

  ngOnInit() {
  }


  login() {
    if (this.email == '' || this.password == '')
      this.error = "Email and password must be filled out";
    else {
      this.loginservice.authenticate(this.email, this.password).subscribe(
        (data: any) => {
          console.log(data)

          this.LogIn.next();
          this.idLoginUser = sessionStorage.getItem('id');
          this.router.navigate(['profile/:email']);
          this.invalidLogin = false
        },
        (error: { message: string | null; }) => {
          this.invalidLogin = true
          this.error = "Invalid email or password or your account is not active";

        })
    }
  }



}

