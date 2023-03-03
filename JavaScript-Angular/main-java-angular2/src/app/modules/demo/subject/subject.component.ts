import { Component, OnDestroy, OnInit } from '@angular/core';
import { BehaviorSubject, Subject, Subscription } from 'rxjs';

@Component({
  selector: 'app-subject',
  templateUrl: './subject.component.html',
  styleUrls: ['./subject.component.scss']
})
export class SubjectComponent implements OnInit, OnDestroy {

  ngOnDestroy(): void {
    this.observer.unsubscribe();
  }

  ngOnInit(): void {
    // let observer = this.subject.subscribe(data => {
    //   console.log(data);
    // });
    this.observer = this.subject2.subscribe({
      next : (data) => {
        console.log("In data : " + data)
      },
      error(err){
        console.log("In error : " + err)
      },
      complete(){
        console.log("In complete : ")
      }
    })


  }
  observer! : Subscription;
  input : string = "";
  subject : BehaviorSubject<string> = new BehaviorSubject<string>("Coucou");
  subject2 : BehaviorSubject<string> = new BehaviorSubject<string>("Coucou");

  sendData(){
    if (this.input == '')
      this.subject2.error('CPT');
    else if (this.input == 'stop')
      this.subject2.complete();
    this.subject2.next(this.input)
  }

}
