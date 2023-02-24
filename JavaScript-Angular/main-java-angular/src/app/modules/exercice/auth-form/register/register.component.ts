import { Component } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, ValidationErrors, ValidatorFn, Validators } from '@angular/forms';
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
    cluf : [false, [Validators.requiredTrue]]},
    { validators : this.confirmPass() }
  )

  register() {
    let values = this.registerForm.value
    this.message = this._autService.register(values.pseudo, values.email, values.password);
    console.log(this.message);
  }

  confirmPass() : ValidatorFn {
    return (control : AbstractControl) : ValidationErrors | null => {
      return ( control.get('confirmation')?.value == control.get('password')?.value ) ? null : { same : true } ;
    }
  }


}
