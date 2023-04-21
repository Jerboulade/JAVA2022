import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserRoutingModule } from './user-routing.module';
import { UserBannerComponent } from './user-banner/user-banner.component';
import { UserMainComponent } from './user-main/user-main.component';
//import { SharedModuleModule } from 'src/app/shared/shared-module/shared-module.module';
import { UserAllComponent } from './user-all/user-all.component';


@NgModule({
  declarations: [
    UserBannerComponent,
    UserMainComponent,
    UserAllComponent
  ],
  imports: [
    CommonModule,
    UserRoutingModule,
    //SharedModuleModule
  ]
})
export class UserModule { }
