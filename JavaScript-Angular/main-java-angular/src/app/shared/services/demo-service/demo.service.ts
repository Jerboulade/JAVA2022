import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DemoService {

  users : user[] = [];
  constructor() { }


  addUser(u : user){
    this.users.push(u);
  }

  removeUser(index : number){
    this.users.splice(index, 1);
  }

}



export interface user{
  name : string;
  email : string;
}
