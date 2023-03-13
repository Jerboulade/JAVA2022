import { Component, Input, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { Pokemon, Stats, Types } from 'src/app/shared/models/pokemon';
import { PokeService } from 'src/app/shared/services/poke/poke.service';

@Component({
  selector: 'app-show',
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.scss']
})
export class ShowComponent implements OnInit, OnDestroy{

  pokemon : Pokemon | undefined;
  observer! : Subscription;
  errorMessage : string = "";

  constructor(private _pokeService : PokeService, private _activatedRoute : ActivatedRoute ){
    this._activatedRoute.paramMap.subscribe(params => {
      this.ngOnInit();
  });
  }

  ngOnDestroy(): void {
    this.observer.unsubscribe;
  }
  ngOnInit(): void {
    this.observer = this._pokeService.getPokemonById(this._activatedRoute.snapshot.params['id']).subscribe({
      next : (data) => {
        this.pokemon = data;
        //console.log(this._activatedRoute.snapshot.params['id'])
      },
      error : (err) => {
        switch(err.status){
          case 0 : this.errorMessage = "Broken server"
          break;
          case 404 : this.errorMessage = "Pokemon not found"
          break;
        }
      }
    });
  }
}
