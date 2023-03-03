import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Article } from 'src/app/shared/models/article';
import { ExerciceModule } from '../../exercice.module';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  constructor() {
    this.compteur = this.articles.length + 1
  }

  articles : Article[] = [
    {
      id : 1,
      name : "Sherman",
      price : 10000000,
      category : "tank",
      creationDate : new Date("06/28/1914"),
      description : "Bon gros camion qui tire des obus",
      rate : 5
    }
  ];
  compteur : number;

  addArticle(article : Article)  : string {
    this.articles.push(article);
    this.compteur++;
    return "Article " + article.name + " created";
  }

  updateArticle(updated : Article){
    let i : number = this.articles.findIndex(art => art.id == updated.id)
    this.articles[i] = updated;
  }

  removeArticle(id : number){
    let i : number = this.articles.findIndex(art => art.id == id)
    this.articles.splice(i, 1);
  }
}
