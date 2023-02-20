import { Injectable } from '@angular/core';
import { Article } from 'src/app/modules/exercice/shopping/shopping.component';

@Injectable({
  providedIn: 'root'
})
export class ShoppingService {

  articles : Article[] = [];

  constructor() { }

  addArticle(name : string, price : number){
    // fonctionne pas
    let searchArt = this.articles.find(art => art.name == name)

    if (searchArt){
      searchArt.price += price;
    }
    else{
      let art = new Article(name, price)
      this.articles.push(art);
    }
  }

  removeArticle(index : number){
    this.articles.splice(index, 1);
  }


}

