import { Component } from '@angular/core';
import { DemoService, user } from 'src/app/shared/services/demo-service/demo.service';

@Component({
  selector: 'app-table1',
  templateUrl: './table1.component.html',
  styleUrls: ['./table1.component.scss']
})
export class Table1Component {
  constructor(private _demoService : DemoService){ }

  name : string = '';
  email : string = '';

  createUser(){
    let newUser : user = {
      name : this.name,
      email : this.email
    }
    this._demoService.addUser(newUser);

  }


}
