import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Card } from '../pages/module/card';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CardService {
  constructor(private http:HttpClient) { }
  private url="http://localhost:8082/api/card"

public addCard(card:Card):Observable<any>
{
return this.http.post<any>(`${this.url}/addCard`,card);
}
public getCardById(cardId:number)
{
return this.http.get<any>(`${this.url}/${cardId}`)
}
}
