import { Patient } from "./patient";
import { DatePipe } from '@angular/common';
import { MedCenter } from "./medCenter";


interface AppointmentInterface{

    id:number;
    start:string;
    duration:number;
    deleted:boolean;
    reserved:boolean;
    patient:Patient;
    medCenter:MedCenter;
}
export class Appointment implements AppointmentInterface{
    id:number;
    start:string;
    duration:number;
    deleted:boolean;
    reserved:boolean;
    patient:Patient;
    medCenter:MedCenter;
    
    constructor(obj:AppointmentInterface){
        this.id=obj.id;
        this.start=obj.start;
        this.duration=obj.duration;
        this.deleted=obj.deleted;
        this.reserved=obj.reserved;
        this.patient=obj.patient;
        this.medCenter=obj.medCenter;

    } 

    
}