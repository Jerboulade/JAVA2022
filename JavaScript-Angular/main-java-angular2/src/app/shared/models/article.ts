export interface Article {
  id : number;
  name : string;
  price : number;
  category : string;
  creationDate : Date;
  description : string,
  rate : number
  [key : string] : any;
}
