import { Address } from "./address";



interface UserInterface{

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


    
}
export class User implements UserInterface{
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


    constructor(obj:UserInterface){
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


    } 
}