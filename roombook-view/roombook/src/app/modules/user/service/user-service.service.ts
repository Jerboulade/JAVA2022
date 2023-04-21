import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/app/shared/model/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService /* implements OnInit */ {

  constructor(private _http : HttpClient) { }

  users() : Observable<User[]> {
    return this._http.get<User[]>("http://localhost:8080/user/all")
  }
}
