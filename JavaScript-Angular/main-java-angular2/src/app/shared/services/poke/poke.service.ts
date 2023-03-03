import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Pokemon } from '../../models/pokemon';

@Injectable({
  providedIn: 'root'
})
export class PokeService {

  private pokeURL : string = "https://pokeapi.co/api/v2/pokemon";
  constructor(private _http : HttpClient) { }

  getPikachu(){
    return this._http.get<Pokemon>(this.pokeURL + "/" + "pikachu");
  }
}
