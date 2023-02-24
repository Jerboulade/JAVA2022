import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MyModuleRoutingModule } from './my-module-routing.module';
import { MyComponentComponent } from './my-component/my-component.component';


@NgModule({
  declarations: [
    MyComponentComponent
  ],
  imports: [
    CommonModule,
    MyModuleRoutingModule
  ]
})
export class MyModuleModule { }
