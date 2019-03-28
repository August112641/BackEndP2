import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders,  } from '@angular/common/http';
import { Observable } from 'rxjs';


const httpOptions = {
  headers: new HttpHeaders({'Authorization': 'Bearer '+'BQCiCdltMaWFPFz5JqAOCj2ncXI6xgAXkaR4ZZkh0_eL9o7a8SWXrhq6ZctNP41r-tR-nHBDsEi1A7E9F1JqcOTZxYctArPYMbNu8lA9HCcmsyQKaDu_vvMlOVb7ckn_yyhiCl5X5d7uj4YxSX1PpVIMjQqB1VoVcZuzmgsdqW46Ykbvyrw4FHZKn0brtjN9a8oMN0JthzdjukCAybfEjfV4wA' })
};

@Injectable({
  providedIn: 'root'
})
export class GetPlayService {
  private creatUrl = 'https://api.spotify.com/v1/users/1244653463/playlists'
  private baseUrl = 'https://api.spotify.com/v1/tracks/3n3Ppam7vgaVa1iaRUc9Lp';

  constructor(
    private http: HttpClient
   ) { }

    private data: Playlist = {
      
        name: "Anugular Playlist",
        description: "name",
        public: false
    
        
      
    };

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
