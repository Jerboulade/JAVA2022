import { Injectable } from '@angular/core';
import { UserModel } from 'src/app/shared/model/user-model/user-model.model';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  users : UserModel[] = [
    { email : 'pol.pol.be', pseudo : 'pol', password : 'pol'},
    { email : 'pul.pul.be', pseudo : 'pul', password : 'pul'},
    { email : 'pil.pil.be', pseudo : 'pil', password : 'pil'},
    { email : 'pul.pul.be', pseudo : 'pul', password : 'pul'},
    { email : 'pal.pal.be', pseudo : 'pal', password : 'pal'}
  ]

  constructor() { }

  findUserByEmail(email : string) : UserModel | undefined {
    return this.users.find(u => u.email == email);
  }
}


