import { Component, OnDestroy, OnInit } from '@angular/core';
import { PokeService } from 'src/app/shared/services/poke/poke.service';

@Component({
  selector: 'app-pokedex',
  templateUrl: './pokedex.component.html',
  styleUrls: ['./pokedex.component.scss']
})
export class PokedexComponent{

  pokemonIndex! : number;

}
