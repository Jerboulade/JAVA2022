import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { UserModel } from '../../model/user-model/user-model.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  users : UserModel[] = [];
  loggedAs! : UserModel | undefined;

  constructor(private _router : Router) { }

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
    setTimeout(() => {this._router.navigate(['/exercice/auth-form'])}, 2000)
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
    setTimeout(() => {this._router.navigate(['/exercice/auth-form'])}, 2000)
    return ("Logged as " + user.pseudo);
  }

  logout() : string {
    if (!this.loggedAs)
      return "Nobody's logged";
    this.loggedAs = undefined;
    return "Log out successfully";
  }

}
