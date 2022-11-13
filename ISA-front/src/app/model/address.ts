interface AddressInterface{

    id:number;
    street:string;
    city:string;
    number:number;


    
}
export class Address implements AddressInterface{
    id:number;
    street:string;
    city:string;
    number:number;



    constructor(obj:AddressInterface){
        this.id=obj.id;
        this.street=obj.street;
        this.city=obj.city;
        this.number=obj.number;


    } 
}