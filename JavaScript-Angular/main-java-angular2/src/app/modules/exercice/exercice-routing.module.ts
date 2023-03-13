import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from 'src/app/shared/guard/auth/auth.guard';
import { AllComponent } from './crud/all/all.component';
import { CreateComponent } from './crud/create/create.component';
import { OneComponent } from './crud/one/one.component';
import { UpdateComponent } from './crud/update/update.component';
import { ExerciceBannerComponent } from './exercice-banner/exercice-banner.component';
import { PokedexComponent } from './pokedex/pokedex.component';
import { ShowComponent } from './pokedex/show/show.component';

const routes: Routes = [
  { path : '', component : ExerciceBannerComponent, children :  [
    { path : 'article/all', component : AllComponent, canActivate : [AuthGuard] },
    { path : 'article/create', component : CreateComponent },
    { path : 'article/:id', component : OneComponent },
    { path : 'article/update/:id', component : UpdateComponent },
    { path : 'pokedex', component : PokedexComponent, children : [
      { path : ':id', component : ShowComponent }
    ] }

  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ExerciceRoutingModule { }
