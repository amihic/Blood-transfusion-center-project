import { User } from "./user";



interface ProfileInterface{

    user:User;
    category:string;
    points:number;
    

    //bloodType:string;
    //points:number;
    //penalties:number;
    //complaints:Complaint[];
    //category:string;


    
}
export class Profile implements ProfileInterface{
    user:User;
    category:string;
    points:number;

    //bloodType:string;
    //points:number;
    //penalties:number;
    //complaints:Complaint[];
    //category:string;


    constructor(obj:ProfileInterface){
        this.user=obj.user;
        this.category = obj.category;
        this.points = obj.points;
        
        //this.bloodType=obj.bloodType;
        //this.points=obj.points;
        //this.penalties=obj.penalties;
        //this.category=obj.category;


    } 
}