import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private isConnected = false

  constructor() { }

  connect(){
    localStorage.setItem('token', 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c');
    this.isConnected = true;
  }

  disconnect(){
    localStorage.removeItem('token')
    this.isConnected = false;
  }

  get isConnect() : boolean{
    return this.isConnected;
    //return localStorage.getItem('token') != undefined;
  }
}
