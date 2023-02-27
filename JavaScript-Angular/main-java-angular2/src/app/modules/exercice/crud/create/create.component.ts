import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Article } from 'src/app/shared/models/article';
import { ArticleService } from '../../service/article/article.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.scss']
})
export class CreateComponent {

    constructor(private _formBuilder : FormBuilder, private _articleService : ArticleService, private _router : Router){}

  articleForm : FormGroup = this._formBuilder.group({
    name : ['', Validators.required],
    price : ['', Validators.required],
    category : ['', Validators.required],
    description : ['']
  })

  addArticle(){
    let article : Article = {
      id : this._articleService.articles.length + 1,
      name : this.articleForm.value.name,
      price : this.articleForm.value.price,
      category : this.articleForm.value.category,
      creationDate : new Date(),
      description : this.articleForm.value.description,
      rate : this.articleForm.value.rate
    }
    this._articleService.addArticle(article);
    this._router.navigate(['./exercice/article/all']);

  }
}
