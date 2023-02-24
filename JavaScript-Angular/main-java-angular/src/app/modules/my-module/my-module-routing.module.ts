import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MyComponentComponent } from './my-component/my-component.component';

const routes: Routes = [
  { path : 'component', component : MyComponentComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MyModuleRoutingModule { }
