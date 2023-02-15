import { Component } from '@angular/core';

@Component({
  selector: 'app-structural-directive',
  templateUrl: './structural-directive.component.html',
  styleUrls: ['./structural-directive.component.scss']
})
export class StructuralDirectiveComponent {

display : boolean = true;
selector! : number;
users : user[] = [
  {name : 'pol', age : 23},
  {name : 'pil', age : 32},
  {name : 'pal', age : 43},
  {name : 'poul', age : 51},
]


setDisplay(){
  this.display = !this.display;
}

}

export interface user{
  name : string;
  age : number;
}
