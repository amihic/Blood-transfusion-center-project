import { Address } from "./address";



interface PatientInterface{

    id:number;
    email:string;
    password1:string;
    password2:string;
    firstName:string;
    lastName:string;
    address:string;
    city:string;
    country:string;
    phoneNumber:string;
    jmbg:string;
    gender:string;
    job:string;
    info:string;
    isActivated:boolean;

    //bloodType:string;
    //points:number;
    //penalties:number;
    //complaints:Complaint[];
    //category:string;


    
}
export class Patient implements PatientInterface{
    id:number;
    email:string;
    password1:string;
    password2:string;
    firstName:string;
    lastName:string;
    address:string;
    city:string;
    country:string;
    phoneNumber:string;
    jmbg:string;
    gender:string;
    job:string;
    info:string;
    isActivated:boolean;

    //bloodType:string;
    //points:number;
    //penalties:number;
    //complaints:Complaint[];
    //category:string;


    constructor(obj:PatientInterface){
        this.id=obj.id;
        this.email=obj.email;
        this.password1=obj.password1;
        this.password2=obj.password2;
        this.firstName=obj.firstName;
        this.lastName=obj.lastName;
        this.address=obj.address;
        this.city=obj.city;
        this.country=obj.country;
        this.phoneNumber=obj.phoneNumber;
        this.jmbg=obj.jmbg;
        this.gender=obj.gender;
        this.job=obj.job;
        this.info=obj.info;
        this.isActivated=obj.isActivated;
        //this.bloodType=obj.bloodType;
        //this.points=obj.points;
        //this.penalties=obj.penalties;
        //this.category=obj.category;


    } 
}