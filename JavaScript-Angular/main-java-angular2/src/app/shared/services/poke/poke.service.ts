import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable, tap } from 'rxjs';
import { Pokemon } from '../../models/pokemon';

@Injectable({
  providedIn: 'root'
})
export class PokeService {

  private pokeURL : string = "https://pokeapi.co/api/v2/pokemon/";
  constructor(private _http : HttpClient) { }

  getPikachu() : Observable<Pokemon> {
    return this._http.get<Pokemon>(this.pokeURL + "pikachu").pipe(map((poke) => {
      return {
        ...poke,
        height : poke.height * 10,
        weight : poke.weight / 10
      }
    }),
    tap((poke) => console.log(poke))
    );
  }

  getPokemonById(id : number) : Observable<Pokemon> {
    return this._http.get<Pokemon>(this.pokeURL + id)
  }

  getPokemonByName(name : string) : Observable<Pokemon> {
    return this._http.get<Pokemon>(this.pokeURL + name)
  }
}
