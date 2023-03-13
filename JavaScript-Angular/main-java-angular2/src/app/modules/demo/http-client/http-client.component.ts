import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Pokemon } from 'src/app/shared/models/pokemon';
import { PokeService } from 'src/app/shared/services/poke/poke.service';

@Component({
  selector: 'app-http-client',
  templateUrl: './http-client.component.html',
  styleUrls: ['./http-client.component.scss']
})
export class HttpClientComponent implements OnInit {

  constructor(private _pokeService : PokeService, private _activatedRoutes : ActivatedRoute){}

  pokemon! : Pokemon;
  ///headers : string[] = [];
  errorMessage : string = "";
  pokemon2! : Pokemon;

  ngOnInit(): void {
    this._pokeService.getPikachu().subscribe({
      next : (data) => {
        this.pokemon = data;
        //this.headers = Object.keys(this.pokemon as Pokemon);
        //console.log(this.pokemon);
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
    // --------------
    let data = this._activatedRoutes.snapshot.data['pikachu'];
    if (data.error){
      this.errorMessage = data.error.statusText;
    }
    else{
      this.pokemon2 = data;
    }
  }


}
