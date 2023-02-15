import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BindingComponent } from './modules/demo/binding/binding.component';
import { MainDemoComponent } from './modules/demo/main-demo/main-demo.component';
import { PipesComponent } from './modules/demo/pipes/pipes.component';
import { PipesComponent as PipesExComponent } from './modules/exercice/pipes/pipes.component';
import { MainExerciceComponent } from './modules/exercice/main-exercice/main-exercice.component';
import { DirectiveComponent } from './modules/demo/directive/directive.component';
import { StructuralDirectiveComponent } from './modules/demo/structural-directive/structural-directive.component';

const routes: Routes = [
  { path : 'exercice', component : MainExerciceComponent, children : [
    { path : 'pipes', component : PipesExComponent }
  ]},
  { path : 'demo', component : MainDemoComponent, children : [
    { path : 'binding', component : BindingComponent },
    { path : 'pipes', component : PipesComponent },
    { path : 'directive', component : DirectiveComponent },
    { path : 'structural-directive', component : StructuralDirectiveComponent }
  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
