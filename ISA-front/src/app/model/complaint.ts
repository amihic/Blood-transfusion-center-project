import { MedCenter } from "./medCenter";
import { Patient } from "./patient";

interface ComplaintInterface{

    id:number;
    patient:Patient;
    name:string;
    description:string;
    complaintType:string;
    medCenter:MedCenter;
}
export class Complaint implements ComplaintInterface{
    id:number;
    patient:Patient;
    name:string;
    description:string;
    complaintType:string;
    medCenter:MedCenter;
    
    constructor(obj:ComplaintInterface){
        this.id=obj.id;
        this.patient=obj.patient;
        this.name=obj.name;
        this.description=obj.description;
        this.complaintType=obj.complaintType;
        this.medCenter=obj.medCenter;

    }   
}