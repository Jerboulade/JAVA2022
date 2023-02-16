import { Component } from '@angular/core';

@Component({
  selector: 'app-input-output',
  templateUrl: './input-output.component.html',
  styleUrls: ['./input-output.component.scss']
})
export class InputOutputComponent {

  myStringFromParent : string = "Written in parent";

  outputMessageFromChild : string = "Empty"

  affectMessage(value : string){
    this.outputMessageFromChild = value;
  }
}
