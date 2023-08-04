import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Booking } from '../pages/module/booking';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookingService {
  constructor(private http:HttpClient) { }
  private url="http://localhost:8082/api/booking"

  public bookTrainService(trainId:number,customerId:number,booking:Booking):Observable<any>
{
return this.http.post<any>(`${this.url}/${trainId}/${customerId}`,booking);
}
public getBookingById(bookingId:number)
{
return this.http.get<any>(`${this.url}/${bookingId}`)
}

public getAllBookingsByCustomerIdService(customerId:number):Observable<Booking>
{
  return this.http.get<Booking>(`${this.url}/customer/${customerId}`);
}
public getAllBookingsService():Observable<Booking[]>
{
  return this.http.get<Booking[]>(`http://localhost:8082/api/booking/bookings`);
}
public deleteBookingService(bookingId:number):Observable<any>{
  return this.http.delete(`${this.url}/${bookingId}`);
}

public getAllBookingsByTrainIdService(trainId:number):Observable<Booking[]>
{
  return this.http.get<Booking[]>(`${this.url}/${trainId}`)
}
}