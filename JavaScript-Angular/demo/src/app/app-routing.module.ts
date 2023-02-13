import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactComponent } from './contact/contact.component';
import { MenuPokebowlComponent } from './modules/menu-pokebowl/menu-pokebowl.component';
import { MenuSushiComponent } from './modules/menu-sushi/menu-sushi.component';
import { MenuComponent } from './modules/menu/menu.component';

// path are written here
const routes: Routes = [
  {path: 'menu', component : MenuComponent, children : [
    {path : 'sushi', component : MenuSushiComponent},
    {path : 'pokebowl', component : MenuPokebowlComponent}
  ]},
  {path: 'contact', component : ContactComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
