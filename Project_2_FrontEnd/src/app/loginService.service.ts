import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  clientId = 'b72324b7926347dc83e63ae5d04366f4';
  responseType = 'code';
  redirectUri = 'http://localhost:4200/callback';
  scope = 'user-read-private%20user-read-email';
  urlQuery = `?client_id=${this.clientId}&response_type=code&redirect_uri=${this.redirectUri}&scope=${this.scope}`;
  url = `https://accounts.spotify.com/authorize${this.urlQuery}`;

  constructor(private http: HttpClient) { }


}
