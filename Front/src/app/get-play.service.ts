import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';


const httpOptions = {
  hearders: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class GetPlayService {

  private baseUrl = 'http://api.spotify.com/v1/tracks/';

  constructor(
    private http: HttpClient
   ) { }

   getTrack(id: string):Observable<Track>{
     return this.http.get<Track>(this.baseUrl);
   }
}
