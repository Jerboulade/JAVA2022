import { Component } from '@angular/core';
import { UserModel } from 'src/app/shared/model/user-model/user-model.model';
import { AuthService } from 'src/app/shared/services/auth/auth.service';

@Component({
  selector: 'app-auth-form',
  templateUrl: './auth-form.component.html',
  styleUrls: ['./auth-form.component.scss']
})
export class AuthFormComponent {
  message : string | undefined = "";

  constructor(private _authService : AuthService){}

  get loggedAs() : string | undefined{
    if (!this._authService.loggedAs)
      return undefined;
    return this._authService.loggedAs.pseudo;
  }

  logout() {
    this.message = this._authService.logout();
    setTimeout(() => { this.message = undefined}, 1000)
  }
}
