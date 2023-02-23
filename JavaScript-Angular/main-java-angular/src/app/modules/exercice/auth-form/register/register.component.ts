import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from 'src/app/shared/services/auth/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {

  constructor( private _autService : AuthService, private _formBuilder : FormBuilder){}

  message : string = "";
  registerForm : FormGroup = this._formBuilder.group({
    pseudo : ['', [Validators.required]],
    email : ['test@email.domain', [Validators.email, Validators.required]],
    password : ['', [Validators.required, Validators.minLength(8)]],
    confirmation : ['', [Validators.required, Validators.minLength(8)]],
    cluf : [false, [Validators.requiredTrue]]
  })

  register() {
    let values = this.registerForm.value
    this.message = this._autService.register(values.pseudo, values.email, values.password);
    console.log(this.message);
  }
}
