import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Traveller } from '../pages/module/traveller';

@Injectable({
  providedIn: 'root'
})
export class TravellerService 
{

  private url="http://localhost:8082/api/train";

  constructor(private httpclient:HttpClient) { }

  public getAllTraveller()
  {
    return this.httpclient.get("http://localhost:8082/api/traveller/travellers")
  }

  public addTraveller(traveller:Traveller)
  {
    return this.httpclient.post('http://localhost:8082/api/traveller/add',traveller);
  }

}
