import { Injectable } from '@angular/core';
import {User} from "../../models/user.model";
import {AuthenticationService} from "../authentication/authentication.service";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export abstract class RequestBaseService {

  protected currentUser: User = new User();

  protected constructor(protected authenticationSercive: AuthenticationService, protected http: HttpClient) {
    this.authenticationSercive.currentUser.subscribe({
      next: data => {
        this.currentUser = data;
      }
    })
  }

  get getHeaders(): HttpHeaders {
    return new HttpHeaders(
      {
        authorization: 'Bearer ' + this.currentUser?.token,
        "Content-Type": "application/json; charset=UTF-8"
      }
    )
  }
}
