import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BannerComponent } from './shared/components/banner/banner.component';
import { MainDemoComponent } from './modules/demo/main-demo/main-demo.component';
import { MainExerciceComponent } from './modules/exercice/main-exercice/main-exercice.component';
import { BindingComponent } from './modules/demo/binding/binding.component';
import { FormsModule } from '@angular/forms';
import { PipesComponent } from './modules/demo/pipes/pipes.component';
import { TempPipe } from './shared/pipes/temp.pipe';
import { ChronoPipe } from './shared/pipes/chrono/chrono.pipe'
import { PipesComponent as PipesExComponent } from './modules/exercice/pipes/pipes.component';
import { DirectiveComponent } from './modules/demo/directive/directive.component';
import { StructuralDirectiveComponent } from './modules/demo/structural-directive/structural-directive.component';
import { HoverColorDirective } from './modules/demo/custom-directive/hover-color.directive';
import { Exo1Component } from './modules/exercice/exo1/exo1.component';
import { InputOutputComponent } from './modules/demo/input-output/input-output.component';
import { EnfantComponent } from './modules/demo/input-output/enfant/enfant.component';
import { ShoppingComponent } from './modules/exercice/shopping/shopping.component';
import { ListViewComponent } from './modules/exercice/shopping/list-view/list-view.component';
@NgModule({
  declarations: [
    AppComponent,
    BannerComponent,
    MainDemoComponent,
    MainExerciceComponent,
    BindingComponent,
    PipesComponent,
    TempPipe,
    ChronoPipe,
    PipesExComponent,
    DirectiveComponent,
    StructuralDirectiveComponent,
    HoverColorDirective,
    Exo1Component,
    InputOutputComponent,
    EnfantComponent,
    ShoppingComponent,
    ListViewComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
