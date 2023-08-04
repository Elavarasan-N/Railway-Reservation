import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Account } from '../pages/module/account';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  constructor(private http:HttpClient) { }
  private url="http://localhost:8082/api/account"

public createAccount(customerId:number,account:Account):Observable<any>
{
return this.http.post<any>(`${this.url}/${customerId}`,account);
}
public getAccountById(accountId:number)
{
return this.http.get<any>(`${this.url}/${accountId}`)
}
public getAccountByCustomerId(customerId:number):Observable<Account>
{
  return this.http.get<Account>(`${this.url}/customer/${customerId}`);
}
public updateAccount(accountId:number,account:Account)
{
  return this.http.put(`${this.url}/${accountId}`,account);
}
public getAllAccountsService():Observable<Account[]>
{
  return this.http.get<Account[]>(`http://localhost:8082/api/booking/accounts`);
}
public deleteAccountService(accountId:number):Observable<any>{
  return this.http.delete(`${this.url}/${accountId}`);
}
}
