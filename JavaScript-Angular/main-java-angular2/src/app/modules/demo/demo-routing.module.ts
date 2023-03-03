import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DemoBannerComponent } from './demo-banner/demo-banner.component';
import { ReadAllComponent } from './demo1/read-all/read-all.component';
import { ReadOneComponent } from './demo1/read-one/read-one.component';
import { HttpClientComponent } from './http-client/http-client.component';
import { SubjectComponent } from './subject/subject.component';

const routes: Routes = [
  { path : '', component : DemoBannerComponent, children : [
    { path : 'routing', component : ReadAllComponent },
    { path : 'routing/:id', component : ReadOneComponent },
    { path : 'subject', component : SubjectComponent },
    { path : 'http-client', component : HttpClientComponent }
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DemoRoutingModule { }
