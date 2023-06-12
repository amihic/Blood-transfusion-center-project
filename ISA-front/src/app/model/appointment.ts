import { Patient } from "./patient";
import { DatePipe } from '@angular/common';


interface AppointmentInterface{

    id:number;
    start:string;
    duration:number;
    deleted:boolean;
    reserved:boolean;
    patient:Patient;
}
export class Appointment implements AppointmentInterface{
    id:number;
    start:string;
    duration:number;
    deleted:boolean;
    reserved:boolean;
    patient:Patient;
    
    constructor(obj:AppointmentInterface){
        this.id=obj.id;
        this.start=obj.start;
        this.duration=obj.duration;
        this.deleted=obj.deleted;
        this.reserved=obj.reserved;
        this.patient=obj.patient;

    } 

    
}