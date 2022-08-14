import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Training} from "../../interfaces/training";

@Injectable({
  providedIn: 'root'
})
export class TrainingService {

  constructor(private httpClient: HttpClient) { }

  private trainingUrl = "/api/training";

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  createTraining(training: Training): Observable<any> {
    return this.httpClient.post(this.trainingUrl, training, this.httpOptions)
  }

  getAllTrainings(): Observable<any> {
    return this.httpClient.get(this.trainingUrl, this.httpOptions)
  }

  getTraining(id:string): Observable<any> {
    return this.httpClient.get(`${this.trainingUrl}/${id}`, this.httpOptions)
  }

  updateTraining(id: string | undefined, training: Training): Observable<any> {
    return this.httpClient.put(`${this.trainingUrl}/${id}`, training, this.httpOptions)
  }

  deleteTraining(id: string): Observable<any> {
    return this.httpClient.delete(`${this.trainingUrl}/${id}`, this.httpOptions)
  }

}
