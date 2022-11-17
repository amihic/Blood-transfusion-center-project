interface MedCenterInterface{

    id:number;
    name:string;
    street:string;
    city:string;
    country:string;
    avgRate:number;
    description:string;
    


    
}
export class MedCenter implements MedCenterInterface{
    id:number;
    name:string;
    street:string;
    city:string;
    country:string;
    avgRate:number;
    description:string;
    


    constructor(obj:MedCenterInterface){
        this.id=obj.id;
        this.name=obj.name;
        this.street=obj.street;
        this.city=obj.city;
        this.country=obj.country;
        this.avgRate=obj.avgRate;
        this.description=obj.description;
        


    } 
}