import { Component, OnDestroy, OnInit } from '@angular/core';

@Component({
  selector: 'app-pipes',
  templateUrl: './pipes.component.html',
  styleUrls: ['./pipes.component.scss']
})
export class PipesComponent implements OnInit, OnDestroy{

cpt : number = 0;
isRunning : boolean = false;
pause : boolean = true;
timer! : any;

startChrono(){
  this.timer = setInterval(() => this.cpt++, 1000)
  this.isRunning = true;
}

toDate(cpt : number) : Date{
  return new Date(this.cpt);
}

pauseChrono(){
  clearInterval(this.timer);
  this.isRunning = false;
}

resetChrono(){
  this.cpt = 0;
  this.isRunning = false;
}
ngOnInit(): void {
  console.log("class PipesComponent from Exercice : initialized");
}
ngOnDestroy(): void {
  console.log("class PipesComponent from Exercice : destroyed");
}

}
