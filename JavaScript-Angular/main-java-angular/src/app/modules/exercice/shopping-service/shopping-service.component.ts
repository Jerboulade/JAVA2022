import { Component } from '@angular/core';
import { ShoppingService } from 'src/app/shared/services/shopping-service/shopping.service';
import { Article } from '../shopping/shopping.component';

@Component({
  selector: 'app-shopping-service',
  templateUrl: './shopping-service.component.html',
  styleUrls: ['./shopping-service.component.scss']
})
export class ShoppingServiceComponent {

  nameForm: string = "";
  priceForm: number = 0;

  constructor(private _shoppingService : ShoppingService){}

  get articles() : Article[]{
    return this._shoppingService.articles;
  }

  isValid(){
    return this.nameForm.trim() != "" &&
           this.nameForm.length < 50 &&
           this.priceForm > 0
  }

  addArticle(){
    this._shoppingService.addArticle(this.nameForm, this.priceForm);
  }

  removeArticle(index : number){
    this._shoppingService.removeArticle(index);
  }
}
