import { Component, OnInit } from '@angular/core';
import { MedCenter } from '../model/medCenter';
import { MedCenterService } from '../service/medCenter.service';

@Component({
  selector: 'app-med-centers',
  templateUrl: './med-centers.component.html',
  styleUrls: ['./med-centers.component.css']
})
export class MedCentersComponent implements OnInit {
  medCenters:MedCenter[];
  newMedCenter:MedCenter;


  constructor(private medCenterService:MedCenterService) {
    this.medCenters=[];
    this.newMedCenter = new MedCenter
      (
        {
          id: 1,
          name:"",
          street:"",
          city:"",
          country:"",
          avgRate:0,
          description:""

        }
      );
   }

  ngOnInit(): void {
    this.getAllMedCenters();
  }

  getAllMedCenters()
  {
    this.medCenterService.getMedCenters()
    .subscribe(res => this.medCenters=res);
  }

  getAllMedCentersByName()
  {
    this.medCenterService.getMedCentersByName()
    .subscribe(res => this.medCenters=res);
  }

  getAllMedCentersByCity()
  {
    this.medCenterService.getMedCentersByCity()
    .subscribe(res => this.medCenters=res);
  }

  getAllMedCentersByRating()
  {
    this.medCenterService.getMedCentersByRating()
    .subscribe(res => this.medCenters=res);
  }
  



}
