import { Component } from '@angular/core';
import { AuthService } from '../../services/auth/auth.service';

@Component({
  selector: 'app-banner',
  templateUrl: './banner.component.html',
  styleUrls: ['./banner.component.scss']
})
export class BannerComponent {

  constructor( private _authService : AuthService){}

  get pseudo() : string | undefined {
    return this._authService.loggedAs?.pseudo;
  }

  logout() {
    this._authService.logout();
  }

}
