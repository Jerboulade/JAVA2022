import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private isConnected = false

  constructor() { }

  connect(){
    localStorage.setItem('connected', 'true');
    //this.isConnected = true;
  }

  disconnect(){
    localStorage.removeItem('connected')
    //this.isConnected = false;
  }

  get isConnect() : boolean{
    //return this.isConnected;
    let connected : string | null = localStorage.getItem('connected');
    return connected == 'true';
  }
}
