import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Customer } from '../pages/module/customer';
import { Observable } from 'rxjs';
import { Train } from '../pages/module/train';
import { Payment } from '../pages/module/payment';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  constructor(private http:HttpClient) { }
  private url1="http://localhost:8082/api/train"

  public getTrainDetailsService(trainId:number,):Observable<Train>
  {
    return this.http.get<Train>(`${this.url1}/${trainId}`)
  }

  private url2="http://localhost:8082/api/customer"
  public getCustomerDetailsService(customerId:number):Observable<Customer>
  {
    return this.http.get<Customer>(`${this.url2}/${customerId}`)
  }

  public bookTrainService(trainId:number,customerId:number,train:Train):Observable<any>
{
return this.http.put(`${this.url1}/${trainId}/${customerId}`,train);
}

private url3="http://localhost:8082/api/payment"
 public addToPaymentService(trainId:number,customerId:number,bookingId:number,payment:Payment):Observable<any>
 {
   return this.http.post<any>(`${this.url3}/${trainId}/${customerId}/${bookingId}`,payment)
 }
 public getAllPaymentsService():Observable<Payment[]>
 {
   return this.http.get<Payment[]>("http://localhost:8082/api/payment/payments")
 }
 public getPaymentDetailsService(paymentId:number):Observable<Payment>
 {
   return this.http.get<Payment>(`${this.url3}/${paymentId}`)
 }
 public checkAvailabilityService(trainId:number):Observable<any>
 {
   return this.http.get<any>(`${this.url1}/${trainId}`);
 }
}

