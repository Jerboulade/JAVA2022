import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-enfant',
  templateUrl: './enfant.component.html',
  styleUrls: ['./enfant.component.scss']
})
export class EnfantComponent {

  @Input()
  myStringInChild : string = "Default Value in child";

  @Output()
  myEvent : EventEmitter<string> = new EventEmitter<string>();

  emitMessage(){
    this.myEvent.emit('Hello World')
  }
}
