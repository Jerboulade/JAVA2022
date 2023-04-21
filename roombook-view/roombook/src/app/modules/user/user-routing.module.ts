import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserAllComponent } from './user-all/user-all.component';
import { UserBannerComponent } from './user-banner/user-banner.component';
import { UserMainComponent } from './user-main/user-main.component';

const routes: Routes = [
  { path : '', component : UserBannerComponent, children : [
    { path : 'all', component : UserAllComponent }
  ]  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }
