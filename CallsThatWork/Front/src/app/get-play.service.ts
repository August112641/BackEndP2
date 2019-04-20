import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders,  } from '@angular/common/http';
import { Observable } from 'rxjs';


const httpOptions = {
  headers: new HttpHeaders({'Authorization': 'Bearer '+'BQBbJN2dVf4dCg9jnLEMi3BaBow2ndB0K7nuQc-LIw_49sbuQVGqFKlnOHg8NETi8ClRUSZe5fwEpWihDeJwN_cFGH6tkUhQPgRZnW8K5MgMkLzHKM7WZm5KSp4b2ujeCnwcfHtooTsVculo6Tan_pmO5Nf8VmW2yGNUCVPAsIUZzxoRRkBCANK73uUSXCQe_CWJN64lKF6Y0sCR3H1JOvufaw' })
};

@Injectable({
  providedIn: 'root'
})
export class GetPlayService {
  private creatUrl = 'https://api.spotify.com/v1/users/1244653463/playlists'
  private baseUrl = 'https://api.spotify.com/v1/tracks/3n3Ppam7vgaVa1iaRUc9Lp';
  private addUrl = 'https://api.spotify.com/v1/users/1244653463/playlists/'

  constructor(
    private http: HttpClient
   ) { }

    private data: Playlist = {
      
        name: "Anugular Playlist",
        description: "name",
        public: false
    
        
      
    };

    addTrack(playlist:string, track:string ) : Observable<Track>{
      return this.http.post<Track>(this.addUrl+playlist+"tracks?uris=spotify%3Atrack%"+track, httpOptions);
    }

   newPlaylist() : Observable<Playlist>{

    return this.http.post<Playlist>(this.creatUrl, this.data, httpOptions);

   }

    getSomething(){
      return this.http.get(this.baseUrl, httpOptions);
    }



   getTrack(id: string ):Observable<Track>{
     return this.http.get<Track>(this.baseUrl, httpOptions);
   }
}
