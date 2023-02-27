import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DemoRoutingModule } from './demo-routing.module';
import { DemoBannerComponent } from './demo-banner/demo-banner.component';
import { ReadOneComponent } from './demo1/read-one/read-one.component';
import { ReadAllComponent } from './demo1/read-all/read-all.component';


@NgModule({
  declarations: [
    DemoBannerComponent,
    ReadOneComponent,
    ReadAllComponent
  ],
  imports: [
    CommonModule,
    DemoRoutingModule
  ]
})
export class DemoModule { }
