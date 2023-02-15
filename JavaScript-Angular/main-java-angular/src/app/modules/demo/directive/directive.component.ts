import { Component } from '@angular/core';

@Component({
  selector: 'app-directive',
  templateUrl: './directive.component.html',
  styleUrls: ['./directive.component.scss']
})
export class DirectiveComponent {

  isBold : boolean = false;
  isItalic : boolean = false;
  isChartreuse : boolean = false;
  style : any;
  discoMode : boolean = false;

  setStyle(){
    this.style = {
      'font-weight' : this.isBold ? 'bold' : 'normal',
      'font-style' : this.isItalic ? 'italic' : 'normal',
    }
  }

  setBold(){
    this.isBold = !this.isBold;
    this.setStyle()
  }

  setItalic(){
    this.isItalic = !this.isItalic;
    this.setStyle()
  }

  setDisco(){
    this.discoMode = !this.discoMode;
  }
}
