import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DemoRoutingModule } from './demo-routing.module';
import { DemoBannerComponent } from './demo-banner/demo-banner.component';
import { ReadOneComponent } from './demo1/read-one/read-one.component';
import { ReadAllComponent } from './demo1/read-all/read-all.component';
import { SubjectComponent } from './subject/subject.component';
import { FormsModule } from '@angular/forms';
import { HttpClientComponent } from './http-client/http-client.component';


@NgModule({
  declarations: [
    DemoBannerComponent,
    ReadOneComponent,
    ReadAllComponent,
    SubjectComponent,
    HttpClientComponent
  ],
  imports: [
    CommonModule,
    DemoRoutingModule,
    FormsModule
  ]
})
export class DemoModule { }
