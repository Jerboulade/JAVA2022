import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';

@Component({
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
  providers: [AuthService]
})
export class LoginComponent {

  fUserLogin : FormGroup;

  constructor(
    private $auth: AuthService,
  ) {
    this.fUserLogin = new FormGroup({
      username: new FormControl(null, [Validators.required]),
      password: new FormControl(null, [Validators.required])
    })
    // this.$auth.register('flavian.ovyn@bstorm.be', 'blop@1234=')
    // this.$auth
    //   .login('flavian.ovyn@bstorm.be', 'blop@1234=')
    //   .subscribe(user => console.log(user))
  }

  loginSubmit() {
    this.$auth.login(this.fUserLogin.value.username, this.fUserLogin.value.password).subscribe();
    // console.log(this.fUserLogin.value.username);
  }
}
