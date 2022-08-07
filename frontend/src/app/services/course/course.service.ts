import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Course} from "../../interfaces/course";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  constructor(private httpClient: HttpClient) {
  }

  private courseUrl = "/api/course";

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  createCourse(course: Course): Observable<any> {
    return this.httpClient.post(this.courseUrl, course, this.httpOptions)
  }

  getAllCourse(): Observable<any> {
    return this.httpClient.get(this.courseUrl, this.httpOptions)
  }

  getCourse(id:string): Observable<any> {
    return this.httpClient.get(`${this.courseUrl}/${id}`, this.httpOptions)
  }

  updateCourse(id:string, course:Course): Observable<any> {
    return this.httpClient.put(`${this.courseUrl}/${id}`, course, this.httpOptions)
  }

  deleteCourse(id: string): Observable<any> {
    return this.httpClient.delete(`${this.courseUrl}/${id}`, this.httpOptions)
  }
}
