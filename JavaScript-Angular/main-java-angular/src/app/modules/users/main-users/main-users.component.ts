import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-main-users',
  templateUrl: './main-users.component.html',
  styleUrls: ['./main-users.component.scss']
})
export class MainUsersComponent {

  email : string = "";

  constructor(private _router : Router){}

  submit(){
    console.log('/users/read-user/' + this.email)
    this._router.navigate(['/users/read-user/' + this.email])
  }

}
