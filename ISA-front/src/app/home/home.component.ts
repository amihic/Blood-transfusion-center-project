import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  tEmail:String;
  constructor() {
    this.tEmail =  String(sessionStorage.getItem('email'))
  }

  ngOnInit(): void {}
  

}
