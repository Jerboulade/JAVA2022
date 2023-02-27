import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Article } from 'src/app/shared/models/article';
import { ExerciceModule } from '../../exercice.module';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  constructor() { }

  articles : Article[] = [
    {
      id : 1,
      name : "Sherman",
      price : 10000000,
      category : "tank",
      creationDate : new Date("28/06/1914"),
      description : "Bon gros camion qui tire des obus",
      rate : 5
    }
  ];

  addArticle(article : Article)  : string {
    this.articles.push(article);
    return "Article " + article.name + " created";
  }

  updateArticle(updated : Article){
    let art : Article | undefined = this.articles.find(artt => artt.id == updated.id)
    art = updated;
  }
}
