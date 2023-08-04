import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Customer } from '../pages/module/customer';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService
{

  private url="http://localhost:8082/api/customer";

  constructor(private httpclient:HttpClient) { }

  public getAllCustomer()
  {
    return this.httpclient.get("http://localhost:8082/api/customer/customers")
  }

  public saveCustomer(customer:Customer)
  {
    return this.httpclient.post('http://localhost:8082/api/customer/save',customer);
  }

  public loginCustomer(customer:Customer)
  {
    return this.httpclient.post('http://localhost:8082/api/customer/login',customer);
  }

  public getCustomerById(customerId:number)
  {
    return this.httpclient.get(`${this.url}/${customerId}`);
  }

  public updateCustomer(customerId:number,customer:Customer)
  {
    return this.httpclient.put(`${this.url}/${customerId}`,customer);
  }

 public deleteCustomer(customerId:number)
  {
    console.log(customerId);
    return this.httpclient.delete(`${this.url}/${customerId}`);
  }

  public getCustomerByEmail(customer:Customer):Observable<any>
  {
    return this.httpclient.post<any>("http://localhost:8082/api/customer/forgotpass",customer)
  }
  
}
