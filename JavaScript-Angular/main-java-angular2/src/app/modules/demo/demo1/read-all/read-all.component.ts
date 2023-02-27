import { Component } from '@angular/core';
import { Animal } from 'src/app/shared/models/animal';
import { AnimalService } from 'src/app/shared/services/animal/animal.service';

@Component({
  selector: 'app-read-all',
  templateUrl: './read-all.component.html',
  styleUrls: ['./read-all.component.scss']
})
export class ReadAllComponent {

  animals! : Animal[];

  constructor(private _animalService : AnimalService){
    this.animals = this._animalService.animals;
  }

}
