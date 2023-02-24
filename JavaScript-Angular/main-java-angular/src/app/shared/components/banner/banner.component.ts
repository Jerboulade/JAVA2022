import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth/auth.service';

@Component({
  selector: 'app-banner',
  templateUrl: './banner.component.html',
  styleUrls: ['./banner.component.scss']
})
export class BannerComponent {

  constructor( private _authService : AuthService, private _router : Router){}

  get pseudo() : string | undefined {
    return this._authService.loggedAs?.pseudo;
  }

  logout() {
    this._authService.logout();
    this._router.navigate(['/exercice/auth-form']);
  }

}
