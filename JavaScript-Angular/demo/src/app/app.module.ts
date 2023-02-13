import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BannerComponent } from './Shared/components/banner/banner.component';
import { MenuComponent } from './modules/menu/menu.component';
import { ContactComponent } from './contact/contact.component';
import { MenuSushiComponent } from './modules/menu-sushi/menu-sushi.component';
import { MenuPokebowlComponent } from './modules/menu-pokebowl/menu-pokebowl.component';
@NgModule({
  declarations: [
    AppComponent,
    BannerComponent,
    MenuComponent,
    ContactComponent,
    MenuSushiComponent,
    MenuPokebowlComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
