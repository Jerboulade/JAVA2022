import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from 'src/app/shared/services/auth/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  constructor( private _autService : AuthService, private _formBuilder : FormBuilder){}

  message : string = "";
  loginForm : FormGroup = this._formBuilder.group({
    identity : ['', [Validators.required]],
    password : ['', [Validators.required, Validators.minLength(8)]]
  })

  login(){
    let values = this.loginForm.value
    this.message = this._autService.login(values.identity, values.password);
  }
}
