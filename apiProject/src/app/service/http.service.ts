import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Staples } from '../models/Staples';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private http: HttpClient) { }

  private postHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  getAllStaples(): Observable<Staples[]> {
    return this.http.get<Movie[]>('http://localhost:7000/movies');
  }

  addMovie(movie: Staples): Observable<Staples> {
    return this.http.post<Movie>('http://localhost:7000/movies', movie, { headers: this.postHeaders });
  }

}
