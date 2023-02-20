import { Component } from '@angular/core';
import { AbstractControl, FormArray, FormBuilder, FormControl, FormGroup, ReactiveFormsModule, ValidationErrors, ValidatorFn, Validators } from '@angular/forms';
import { ValidationError } from 'json-schema';

@Component({
  selector: 'app-formulaire',
  templateUrl: './formulaire.component.html',
  styleUrls: ['./formulaire.component.scss']
})
export class FormulaireComponent {

  constructor(private _formBuilder : FormBuilder){}

  // FORM GROUP

  formGroup : FormGroup = this._formBuilder.group({
    userName : ['', [Validators.required, this.moreThanFour()]],
    email : ['test@email.domain', [Validators.email, Validators.required]],
    password : ['', [Validators.required, Validators.minLength(8)]]
  })

  submit(){
    console.log("Submitted : " + this.formGroup.value.userName);
  }

  // FORM GROUP w/ ARRAY

  formGroupArray : FormGroup = this._formBuilder.group({
    groupArray : this._formBuilder.array([new FormControl('', Validators.required)])
  })

  getArray(){
    return this.formGroupArray.get('groupArray') as FormArray
  }

  addControl(){
    this.getArray().push(new FormControl('', Validators.required))
  }

  submitArray(){
    let values = this.formGroupArray.value;
    console.log(values);
    this.getArray().clear()
  }

  removeControl(index : number){
    this.getArray().removeAt(index);
  }


  // CUSTOM VALIDATOR

  moreThanFour() : ValidatorFn{
    return (control : AbstractControl) : ValidationErrors | null => {
      let value = control.value;
      return (value.length > 4) ? null : {tabuse : true};
    }
  }
}
