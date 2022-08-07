import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { RutaAprendizaje } from '../../interfaces/ruta-aprendizaje'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RutaaprendizajeService {

  constructor(private httpClient: HttpClient) { }

  private url = '/api/ruta'

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  crearRutaAprendizaje(ruta: RutaAprendizaje): Observable<any> {
    return this.httpClient.post(this.url, ruta, this.httpOptions)
  }

  listarRutaAprendizaje(): Observable<any> {
    return this.httpClient.get(this.url, this.httpOptions)
  }

  listarPorIdRutaAprendizaje(id: string): Observable<any> {
    return this.httpClient.get(`${this.url}/${id}`, this.httpOptions)
  }

  actualzarRutaAprendizaje(id: string, ruta: RutaAprendizaje): Observable<any> {
    return this.httpClient.put(`${this.url}/${id}`, ruta, this.httpOptions)
  }

  eliminarRutaAprendizaje(id: string): Observable<any> {
    return this.httpClient.delete(`${this.url}/${id}`, this.httpOptions)
  }
}
