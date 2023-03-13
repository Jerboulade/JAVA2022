import { Component, Input } from '@angular/core';
import { Types } from '../../models/pokemon';

@Component({
  selector: 'app-type',
  templateUrl: './type.component.html',
  styleUrls: ['./type.component.scss']
})
export class TypeComponent {

  @Input()
  types! : Types[] | undefined;

}
