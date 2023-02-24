import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainUsersComponent } from './main-users/main-users.component';
import { ReadUserComponent } from './read-user/read-user.component';

const routes: Routes = [
  { path : '', component : MainUsersComponent, children : [
    { path : 'read-user', component : ReadUserComponent },
    { path : 'read-user/:param', component : ReadUserComponent }

  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UsersRoutingModule { }
