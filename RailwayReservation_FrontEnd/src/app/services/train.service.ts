import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Train } from '../pages/module/train';

@Injectable({
  providedIn: 'root'
})
export class TrainService {
  private url="http://localhost:8082/api/train";

  constructor(private httpclient:HttpClient) { }

  public getAllTrain()
  {
    return this.httpclient.get("http://localhost:8082/api/train/trains")
  }

  public addTrain(train:Train)
  {
    return this.httpclient.post('http://localhost:8082/api/train/add',train);
  }

  public getTrainById(trainId:number)
  {
    console.log("GetTrainById"+trainId);
    return this.httpclient.get(`${this.url}/${trainId}`);
  }

  public updateTrain(trainId:number,train:Train)
  {
    return this.httpclient.put(`${this.url}/${trainId}`,train);
  }

  public deleteTrain(trainId:number)
  {
    console.log(trainId);
    return this.httpclient.delete(`${this.url}/${trainId}`);
  }

  public searchTrainByName(trainName:string)
  {
    console.log("service"+trainName);
    return this.httpclient.get(`${this.url}/search/${trainName}`);
  }
}
