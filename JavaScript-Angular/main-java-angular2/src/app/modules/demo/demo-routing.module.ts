import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DemoBannerComponent } from './demo-banner/demo-banner.component';
import { ReadAllComponent } from './demo1/read-all/read-all.component';
import { ReadOneComponent } from './demo1/read-one/read-one.component';

const routes: Routes = [
  {path : '', component : DemoBannerComponent, children : [
    {path : 'routing', component : ReadAllComponent},
    {path : 'routing/:id', component : ReadOneComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DemoRoutingModule { }
