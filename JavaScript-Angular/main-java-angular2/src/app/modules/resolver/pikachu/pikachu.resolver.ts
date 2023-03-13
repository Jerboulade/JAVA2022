import { Injectable } from '@angular/core';
import {
  Router, Resolve,
  RouterStateSnapshot,
  ActivatedRouteSnapshot
} from '@angular/router';
import { catchError, map, Observable, of } from 'rxjs';
import { Pokemon } from 'src/app/shared/models/pokemon';
import { PokeService } from 'src/app/shared/services/poke/poke.service';

@Injectable({
  providedIn: 'root'
})
export class PikachuResolver implements Resolve<Pokemon | any> {

  constructor(private _pokeService : PokeService){}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Pokemon | any> {
    return this._pokeService.getPikachu().pipe(map(poke => poke), catchError(err => {return of({error : err})}));
  }
}
