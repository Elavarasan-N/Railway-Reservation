import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Admin } from '../pages/module/admin';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http:HttpClient) { }
  
  public adminLoginService(admin:Admin):Observable<any>
  {
    return this.http.post<any>("http://localhost:8082/api/admin/login",admin)
  }
}
