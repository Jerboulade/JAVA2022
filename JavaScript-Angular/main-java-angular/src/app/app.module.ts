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
