import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from '../../module/customer';
import { AccountService } from 'src/app/services/account.service';
import { Account } from '../../module/account';
import { TransactionService } from 'src/app/services/transaction.service';
import { Transaction } from '../../module/transaction';

@Component({
  selector: 'app-wallet',
  templateUrl: './wallet.component.html',
  styleUrls: ['./wallet.component.css']
})
export class WalletComponent implements OnInit { 
  customer:Customer=new Customer();
  account:Account=new Account();
  transaction:Transaction=new Transaction();
  customerId:any;
  accountId:any;
  amount:any;
  transactionId:any;
  transactionlist:any;
  constructor(private router:Router,private activatedRoute:ActivatedRoute, private accountService: AccountService,private transactionService:TransactionService){}
  ngOnInit(): void {
    this.customerId = this.activatedRoute.snapshot.params['customerId'];
    console.log(this.customerId);
  this.getAccountDetails();
  this.getTransactionDetails();
  }
  getAccountDetails()
  {
    this.accountService.getAccountByCustomerId(this.customerId).subscribe(
      (data:any)=>{this.account=data,
      console.log(data);
      this.accountId = this.account.accountId;
      this.amount = this.account.amount;
      console.log(this.account.amount);
    }
  )
  }
  getTransactionDetails()
  {
    this.transactionService.getTransactionByCustomerId(this.customerId).subscribe(
      (data:any)=>{
        this.account=data;
        this.transactionlist=this.account;
        console.log(data);
      }
    )
  }
  
  accountprofile()
  {
    this.router.navigate(['/accountprofile',this.accountId]);
  }
  addmoney()
  {
    this.router.navigate(['/money',this.accountId]);
  }
  logOut()
  {
    this.router.navigate(['/welcomepage'])
  }
  
  home()
  {
    this.router.navigate(['/customerhome',this.customerId])
  }
  contactUs()
  {
    this.router.navigate(['/contact'])
  }
  p: number = 1;
  count: number = 5;
}


