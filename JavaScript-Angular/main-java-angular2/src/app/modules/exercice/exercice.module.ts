import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ExerciceRoutingModule } from './exercice-routing.module';
import { CreateComponent } from './crud/create/create.component';
import { UpdateComponent } from './crud/update/update.component';
import { ExerciceBannerComponent } from './exercice-banner/exercice-banner.component';
import { AllComponent } from './crud/all/all.component';
import { OneComponent } from './crud/one/one.component';
import { ArticleService } from './service/article/article.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PokedexComponent } from './pokedex/pokedex.component';
import { TypeComponent } from 'src/app/shared/component/type/type.component';
import { StatComponent } from 'src/app/shared/component/stat/stat.component';
import { ShowComponent } from './pokedex/show/show.component';


@NgModule({
  declarations: [
    CreateComponent,
    UpdateComponent,
    ExerciceBannerComponent,
    AllComponent,
    OneComponent,
    PokedexComponent,
    TypeComponent,
    StatComponent,
    ShowComponent
  ],
  imports: [
    CommonModule,
    ExerciceRoutingModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [
    ArticleService
  ]
})
export class ExerciceModule { }
