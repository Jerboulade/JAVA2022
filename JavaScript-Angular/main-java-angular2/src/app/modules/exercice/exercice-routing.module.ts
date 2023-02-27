import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllComponent } from './crud/all/all.component';
import { CreateComponent } from './crud/create/create.component';
import { OneComponent } from './crud/one/one.component';
import { UpdateComponent } from './crud/update/update.component';
import { ExerciceBannerComponent } from './exercice-banner/exercice-banner.component';

const routes: Routes = [
  { path : '', component : ExerciceBannerComponent, children :  [
    { path : 'article/all', component : AllComponent },
    { path : 'article/create', component : CreateComponent },
    { path : 'article/:id', component : OneComponent },

    { path : 'article/update/:id', component : UpdateComponent }
  ] }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ExerciceRoutingModule { }
