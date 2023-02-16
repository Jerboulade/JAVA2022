import { Component } from '@angular/core';

@Component({
  selector: 'app-exo1',
  templateUrl: './exo1.component.html',
  styleUrls: ['./exo1.component.scss']
})
export class Exo1Component {

nameModel! : string;
ageModel! : number;
users : User[] = new Array;

saveUser(){
  //console.log(this.nameModel + " " + this.ageModel)
  if (!isNaN(this.ageModel) && this.ageModel < 99){
    let user : User = new User(this.nameModel,this.ageModel);
    this.users.push(user);
  }

}

get hasDuplicate() : boolean {
  for (let u of this.users){
    if (u.name === this.nameModel && u.age === this.ageModel)
      return true
  }
  return false
}

deleteUser(index : number){
  this.users.splice(index, 1)
}


}

export class User {
  name : string;
  age : number;

  constructor(_name : string, _age : number){
    this.name = _name;
    this.age = _age;
  }
}
