import { Component } from '@angular/core';

@Component({
  selector: 'app-binding',
  templateUrl: './binding.component.html',
  styleUrls: ['./binding.component.scss']
})
export class BindingComponent {

  maVariable : string = "Les bindings c'est trop cool"
  isClickable : boolean = false
  varIsClickable : string = "broken"

  maMethode(){
    this.maVariable = "Pourquoi tu cliques?"
  }

  reverseIsClickable(){
    this.isClickable = !this.isClickable

    if (this.isClickable)
      this.varIsClickable = "fixed"
    else
      this.varIsClickable = "broken"

  }

}
