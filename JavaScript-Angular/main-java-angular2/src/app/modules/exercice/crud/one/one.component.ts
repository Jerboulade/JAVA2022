import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Article } from 'src/app/shared/models/article';
import { ArticleService } from '../../service/article/article.service';

@Component({
  selector: 'app-one',
  templateUrl: './one.component.html',
  styleUrls: ['./one.component.scss']
})
export class OneComponent implements OnInit{

  article! : Article | undefined;
  headers! : string[];

  constructor(private _articleService : ArticleService, private _activatedRoute : ActivatedRoute){

  }
  ngOnInit(): void {
    let id = this._activatedRoute.snapshot.params['id'];
    this.article = this._articleService.articles.find(a => a.id == id);
    if (this.article)
      this.headers = Object.keys(this.article as Article);
  }

}
