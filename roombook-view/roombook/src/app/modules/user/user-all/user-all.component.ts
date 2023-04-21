import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/shared/model/user.model';
import { UserServiceService } from '../service/user-service.service';

@Component({
  selector: 'app-user-all',
  templateUrl: './user-all.component.html',
  styleUrls: ['./user-all.component.scss']
})
export class UserAllComponent implements OnInit {

  users : User[] | undefined;

  constructor(private _userService : UserServiceService) {}

  ngOnInit(): void {
    this._userService.users().subscribe({
      next : (data : User[]) => {
        this.users = data;
      }
    })
  }
}
