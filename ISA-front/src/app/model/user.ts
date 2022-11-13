import { Address } from "./address";



interface UserInterface{

    id:number;
    email:string;
    password:string;
    firstName:string;
    lastName:string;
    address:string;
    phoneNumber:string;
    jmbg:string;
    dateOfBirth:string;
    gender:string;
    job:string;
    info:string;


    
}
export class User implements UserInterface{
    id:number;
    email:string;
    password:string;
    firstName:string;
    lastName:string;
    address:string;
    phoneNumber:string;
    jmbg:string;
    dateOfBirth:string;
    gender:string;
    job:string;
    info:string;


    constructor(obj:UserInterface){
        this.id=obj.id;
        this.email=obj.email;
        this.password=obj.password;
        this.firstName=obj.firstName;
        this.lastName=obj.lastName;
        this.address=obj.address;
        this.phoneNumber=obj.phoneNumber;
        this.jmbg=obj.jmbg;
        this.dateOfBirth=obj.dateOfBirth;
        this.gender=obj.gender;
        this.job=obj.job;
        this.info=obj.info;


    } 
}