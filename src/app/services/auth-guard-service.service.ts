import { Injectable } from '@angular/core';
import { CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router'

import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

@Injectable()
export class AuthGuardServiceService implements CanActivate {

  constructor(private router: Router, private http: HttpClient) {


  }

  async canActivate(route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Promise<boolean> {




    let resp = await this.http.get<any>('/auth').toPromise()
      .then(data => {

        return data;
      }).catch(err => {
        return false
      })




    if (resp) {
      return true;
    } else {

      window.location.href = "http://localhost:4200/login";

      return false;
    }

  }
}
