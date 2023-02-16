import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Article } from '../shopping.component';

@Component({
  selector: 'app-list-view',
  templateUrl: './list-view.component.html',
  styleUrls: ['./list-view.component.scss']
})
export class ListViewComponent {

  @Input()
  articles : Article[] = [
    { name : 'default', price : 0}
  ];

  @Output()
  deleteEvent : EventEmitter<number> = new EventEmitter<number>();

  sendIndexToParent(indexToEmit : number){
    this.deleteEvent.emit(indexToEmit);
  }


}
