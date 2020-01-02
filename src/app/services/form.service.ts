import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {environment as env} from '../../environments/environment'
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class FormService {

  constructor(private http: HttpClient) { }

  
postUrl(method: string, url: string): Observable<any>{
  return this.http.post(env.url , {method,url})
    
}

getById(id: number): Observable<any>{
 return this.http.get(env.url + id)
}
}

