import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  id: number;
  constructor(private http: HttpClient) { }

  url: 'https://jsonplaceholder.typicode.com/posts';

  getUser(id: number): Observable <User> {
    console.log("Getting user"+id);
    return this.http.get<User>(this.url+"/"+id);
  }
}
