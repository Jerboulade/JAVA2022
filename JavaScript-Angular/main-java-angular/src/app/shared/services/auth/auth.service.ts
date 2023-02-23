import { Injectable } from '@angular/core';
import { UserModel } from '../../model/user-model/user-model.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  users : UserModel[] = [];
  loggedAs! : UserModel | undefined;

  constructor() { }

  register(pseudo : string, email : string, password : string ) : string {
    if ( this.users.find( user => user.email == email ) )
      return "This email already exists!";
    else if (this.users.find( user => user.pseudo == pseudo ))
      return "This pseudo already exists!";
    let newUser : UserModel = {
      pseudo : pseudo,
      email : email,
      password : password
    }
    this.users.push(newUser)
    this.loggedAs = newUser;
    return ( "Register successfully : " + newUser.pseudo );
  }

  login(identity : string, password : string) : string {
    if (this.loggedAs != undefined)
      return "Already logged"
    let user : UserModel | undefined = this.users.find(user => user.email == identity || user.pseudo == identity)
    if (!user)
      return "Not a valid identity";
    if (user.password != password)
      return "Not a valid password";
    this.loggedAs = user;
    return ("Logged as " + user.pseudo);
  }

  logout() : string {
    if (!this.loggedAs)
      return "Nobody's logged";
    this.loggedAs = undefined;
    return "Log out successfully";
  }

}
