import { Component, OnInit } from '@angular/core';
import { Article } from 'src/app/shared/models/article';
import { ArticleService } from '../../service/article/article.service';

@Component({
  selector: 'app-all',
  templateUrl: './all.component.html',
  styleUrls: ['./all.component.scss']
})
export class AllComponent{

  constructor(private _articleService : ArticleService){}

  get articles() : Article[] {
    return this._articleService.articles;
  }

  removeArticle(id : number){
    this._articleService.removeArticle(id);
    console.log(id)
  }

}
