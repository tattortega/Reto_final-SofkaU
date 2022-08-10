import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { LearningRoute } from '../../interfaces/learning-route'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LearningRouteService {

  constructor(private httpClient: HttpClient) { }

  private url = '/api/ruta'

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  createLearningRoute(ruta: LearningRoute): Observable<any> {
    return this.httpClient.post(this.url, ruta, this.httpOptions)
  }

  getAllLearningRoute(): Observable<any> {
    return this.httpClient.get(this.url, this.httpOptions)
  }

  getLearningRoute(id: string): Observable<any> {
    return this.httpClient.get(`${this.url}/${id}`, this.httpOptions)
  }

  updateLearningRoute(id: string | undefined, ruta: LearningRoute): Observable<any> {
    return this.httpClient.put(`${this.url}/${id}`, ruta, this.httpOptions)
  }

  deleteLearningRoute(id: string): Observable<any> {
    return this.httpClient.delete(`${this.url}/${id}`, this.httpOptions)
  }
}
