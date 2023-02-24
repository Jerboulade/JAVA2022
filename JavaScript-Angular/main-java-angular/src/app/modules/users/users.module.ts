import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UsersRoutingModule } from './users-routing.module';
import { ReadUserComponent } from './read-user/read-user.component';
import { MainUsersComponent } from './main-users/main-users.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    ReadUserComponent,
    MainUsersComponent
  ],
  imports: [
    FormsModule,
    CommonModule,
    UsersRoutingModule
  ]
})
export class UsersModule { }
