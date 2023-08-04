import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Transaction } from '../pages/module/transaction';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {
  constructor(private http:HttpClient) { }
  private url="http://localhost:8082/api/transaction"

public addtransaction(transaction:Transaction,customerId:number,accountId:number):Observable<any>
{
return this.http.post<any>(`${this.url}/${customerId}/${accountId}`,transaction);
}
public getTransactionById(transactionId:number)
{
return this.http.get<any>(`${this.url}/${transactionId}`)
}
public getTransactionByAccountId(accountId:number):Observable<any>
{
return this.http.get<any>(`${this.url}/account/${accountId}`)
}
public getTransactionByCustomerId(customerId:number):Observable<any>
{
return this.http.get<any>(`${this.url}/customer/${customerId}`)
}
}
