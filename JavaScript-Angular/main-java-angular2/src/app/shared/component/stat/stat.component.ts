import { Component, Input } from '@angular/core';
import { Stats } from '../../models/pokemon';

@Component({
  selector: 'app-stat',
  templateUrl: './stat.component.html',
  styleUrls: ['./stat.component.scss']
})
export class StatComponent {

  @Input()
  stats! : Stats[] | undefined;
}
