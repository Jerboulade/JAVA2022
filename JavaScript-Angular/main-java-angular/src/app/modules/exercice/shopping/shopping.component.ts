import { Component } from '@angular/core';

@Component({
  selector: 'app-shopping',
  templateUrl: './shopping.component.html',
  styleUrls: ['./shopping.component.scss']
})
export class ShoppingComponent {

  articles : Article[] = new Array;
  nameForm : string = "";
  priceForm! : number;
  sum : number = 0;

  addArticle(){
    let article : Article = new Article(this.nameForm, this.priceForm);
    this.articles.push(article);
    this.sum += this.priceForm;
  }

  isValid(){
    return this.nameForm.trim() != "" &&
           this.nameForm.length < 50 &&
           this.priceForm > 0
  }

  deleteArticle(index : number){
    console.log(index)
    this.articles.splice(index, 1);
  }

}

export class Article {
  name : string;
  price : number;

  constructor(_name : string, _price : number){
    this.name = _name;
    this.price = _price;
  }
}
