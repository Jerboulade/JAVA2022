import { Injectable } from '@angular/core';
import { Animal } from '../../models/animal';

@Injectable({
  providedIn: 'root'
})
export class AnimalService {

  constructor() { }
  animals : Animal[] = [{
    id : 1,
    name : 'Pou',
    birthdate : new Date("16/05/2015"),
    race : "Frison",
    coat : "Noir",
    owner : "Nicolas"
  },
  {
    id : 2,
    name : 'Sushi',
    birthdate : new Date("10/01/2019"),
    race : "Chat",
    coat : "Gris metal",
    owner : "Benjamin"
  },
  {
    id : 3,
    name : 'Nitro',
    birthdate : new Date("14/01/2009"),
    race : "Chat ",
    coat : "Gris metal",
    owner : "Jerome"
  },
  {
    id : 4,
    name : 'Cubitus',
    birthdate : new Date("07/05/2014"),
    race : "Chien",
    coat : "Brun",
    owner : "Mathieu"
  },
  {
    id : 5,
    name : 'Semaphore',
    birthdate : new Date("03/01/2016"),
    race : "Chien",
    coat : "Brun",
    owner : "Mathieu"
  },
  ];
}
