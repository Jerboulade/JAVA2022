import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Article } from 'src/app/shared/models/article';
import { ArticleService } from '../../service/article/article.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.scss']
})
export class UpdateComponent {

  toUpdate! : Article | undefined;

  constructor(private _formBuilder : FormBuilder,
              private _articleService : ArticleService,
              private _activatedRoute : ActivatedRoute,
              private _router : Router){
    let index = this._activatedRoute.snapshot.params['id'];
    console.log(index);
    this.toUpdate = _articleService.articles.find(art => art.id == index);
    console.log(this.toUpdate);
    this.updateForm = this._formBuilder.group({
      name : [this.toUpdate?.name, Validators.required],
      price : [this.toUpdate?.price, Validators.required],
      category : [this.toUpdate?.category, Validators.required],
      description : [this.toUpdate?.description]
    })
  }

  updateForm : FormGroup;

  update(){
    let updated : Article = {
      id : this.toUpdate!.id,
      name : this.updateForm.value.name,
      price : this.updateForm.value.price,
      category : this.updateForm.value.category,
      creationDate : this.toUpdate!.creationDate,
      description : this.updateForm.value.description,
      rate : this.toUpdate!.rate
    };
    this._articleService.updateArticle(updated);
    this._router.navigate(['./exercice/article/all'])
  }
}
