import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';


const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json', 'Authorization': 'Bearer '+'BQB6N0RFv0DtQk1ZuvOSpSt_9CYnMxiDLhR_fbLm0GciJZqWiICsLNUBJYnxZhkVCSTlJMaqOxDcsKEb1hM2GkseCjpDDmg5GTsKik4EcxMHvGgMYfgJ4Fv4haCdyHbG4lzg1r0fdmWKkvyIF_IuX5DerLFYJ3w' })
};

@Injectable({
  providedIn: 'root'
})
export class GetPlayService {

  private baseUrl = 'http://api.spotify.com/v1/tracks/3n3Ppam7vgaVa1iaRUc9Lp';

  constructor(
    private http: HttpClient
   ) { }

    getSomething(){
      return this.http.get(this.baseUrl, httpOptions);
    }

   getTrack(id: string ):Observable<Track>{
     return this.http.get<Track>(this.baseUrl,httpOptions);
   }
}
