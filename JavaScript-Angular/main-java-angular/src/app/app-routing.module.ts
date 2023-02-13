import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BindingComponent } from './modules/demo/binding/binding.component';
import { MainDemoComponent } from './modules/demo/main-demo/main-demo.component';
import { MainExerciceComponent } from './modules/exercice/main-exercice/main-exercice.component';

const routes: Routes = [
  {path : 'exercice', component : MainExerciceComponent},
  {path : 'demo', component : MainDemoComponent, children : [
    {path : 'binding', component : BindingComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
