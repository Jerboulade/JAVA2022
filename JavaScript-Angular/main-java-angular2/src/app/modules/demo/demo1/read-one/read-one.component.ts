import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Animal } from 'src/app/shared/models/animal';
import { AnimalService } from 'src/app/shared/services/animal/animal.service';

@Component({
  selector: 'app-read-one',
  templateUrl: './read-one.component.html',
  styleUrls: ['./read-one.component.scss']
})
export class ReadOneComponent implements OnInit {

  selectedAnimal! : Animal | undefined;

  constructor(private _activatedRoute : ActivatedRoute, private _animalService : AnimalService) {
    // this.selectedAnimal = this._animalService.animals
      this._activatedRoute.paramMap.subscribe(param => {this.ngOnInit()});
  }
  ngOnInit(): void {
    let index : number = this._activatedRoute.snapshot.params['id']
    // console.log(this._activatedRoute.snapshot.params)
    this.selectedAnimal = this._animalService.animals.find(a => a.id == index)
    // console.log(this.selectedAnimal)
  }




}
