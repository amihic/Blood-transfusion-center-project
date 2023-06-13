import { Component, OnInit } from '@angular/core';
import { Complaint } from '../model/complaint';
import { MedCenter } from '../model/medCenter';
import { ComplaintService } from '../service/complaint.service';
import { MedCenterService } from '../service/medCenter.service';

@Component({
  selector: 'app-complaint',
  templateUrl: './complaint.component.html',
  styleUrls: ['./complaint.component.css']
})
export class ComplaintComponent implements OnInit {
  centers:MedCenter[];
  newComplaint:Complaint;
  tEmail:string;
  medCenter:String;

  constructor(private medCenterService:MedCenterService, private complaintService:ComplaintService) {
    this.centers = [];
    this.tEmail="";
    this.medCenter= "";
    this.newComplaint = new Complaint({
      id:0,
      patient:({
        id:1,
            email:"",
            password1:"",
            password2:"",
            firstName:"",
            lastName:"",
            address:"",
            city:"",
            country:"",
            phoneNumber:"",
            jmbg:"",
            gender:"male",
            job:"",
            info:"",
            isActivated:true,
      }),
      name:"",
      description:"",
      complaintType:"",
      medCenter:({
        id: 1,
          name:"",
          street:"",
          city:"",
          country:"",
          avgRate:0,
          description:""
      })
    })
   }

   ngOnInit(): void {
    this.getAllMedCenters();
  }

  getAllMedCenters()
  {
    this.medCenterService.getMedCenters()
    .subscribe(res => this.centers=res);
  }

  sendComplaint(newComplaint:Complaint, medCenter:String)
  {
    this.tEmail =  String(sessionStorage.getItem('email'))
    this.complaintService.sendComplaintByEmail(this.tEmail, newComplaint, medCenter)
    .subscribe((res: Complaint) => this.newComplaint=res);
    window.location.reload();
  }

}
