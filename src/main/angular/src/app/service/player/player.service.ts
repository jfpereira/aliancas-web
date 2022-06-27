import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {RequestBaseService} from "../request-base/request-base.service";
import {HttpClient} from "@angular/common/http";
import {AuthenticationService} from "../authentication/authentication.service";
import {Player} from "../../models/player.model";
import {Observable} from "rxjs";

const API_URL = environment.BASE_URL+'/api/player';


@Injectable({
  providedIn: 'root'
})
export class PlayerService extends RequestBaseService {

  constructor(authenticationService: AuthenticationService, http: HttpClient) {
    super(authenticationService, http);
  }

  savePlayer(player: Player): Observable<any> {
    return this.http.post(API_URL, player, {headers: this.getHeaders});
  }

  deletePlayer(player: Player): Observable<any> {
    return this.http.delete(API_URL + player.id, {headers: this.getHeaders});
  }

  getAllPlayers(): Observable<any> {
    return this.http.get(API_URL, {headers: this.getHeaders});
  }
}
