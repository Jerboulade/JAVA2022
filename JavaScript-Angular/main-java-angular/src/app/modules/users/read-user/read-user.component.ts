import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserModel } from 'src/app/shared/model/user-model/user-model.model';
import { UserServiceService } from '../services/user/user-service.service';

@Component({
  selector: 'app-read-user',
  templateUrl: './read-user.component.html',
  styleUrls: ['./read-user.component.scss']
})
export class ReadUserComponent implements OnInit{

  user! : UserModel | undefined;
  headers!: string[];

  constructor(private _activatedRoute : ActivatedRoute, private _userService : UserServiceService){
    this._activatedRoute.paramMap.subscribe(param => {
      this.ngOnInit();
    })
  }

  ngOnInit(): void {
    let email : string = this._activatedRoute.snapshot.params['param'];
    this.user = this._userService.findUserByEmail(email);
    console.log(this.user);
    this.headers = Object.keys(this.user as UserModel);
  }




}
