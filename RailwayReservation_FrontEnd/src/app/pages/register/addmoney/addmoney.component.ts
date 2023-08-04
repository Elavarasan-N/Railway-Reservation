import { Component, OnInit } from '@angular/core';
import { Payment } from '../../module/payment';
import { Account } from '../../module/account';
import { ActivatedRoute, Router } from '@angular/router';
import { AccountService } from 'src/app/services/account.service';
import { Card } from '../../module/card';
import { CardService } from 'src/app/services/card.service';
import { TransactionService } from 'src/app/services/transaction.service';
import { Transaction } from '../../module/transaction';

@Component({
  selector: 'app-addmoney',
  templateUrl: './addmoney.component.html',
  styleUrls: ['./addmoney.component.css']
})
export class AddmoneyComponent implements OnInit{
  account:Account=new Account();
  card:Card=new Card();
  transaction:Transaction=new Transaction();
  cardId:any;
  accountId: any;
  customerId:any;
  amount:any;
  money:any;
  error:any;

  constructor(private router:Router,private activatedRoute:ActivatedRoute,private cardService:CardService,private transactionService:TransactionService,private accountService: AccountService){}
  ngOnInit(): void {
    this.accountId = this.activatedRoute.snapshot.params['accountId'];
    console.log(this.accountId);
    this.getAccountDetails();
  }
  getAccountDetails()
  {
  this.accountService.getAccountById(this.accountId).subscribe(
    (data:any)=>{this.account=data,
    console.log(data)
    console.log(this.customerId = this.account.customerId);
   console.log(this.amount = this.account.amount);
  }
    );
    }
    
  addMoney()
  {
    this.cardService.addCard(this.card).subscribe(
      (data:any)=>{console.log(data),
        (error:any)=>console.log(error);
        this.cardId = data.cardId;
        this.cardService.getCardById(this.cardId).subscribe(
          (data:any)=>{console.log(data),
            (error:any)=>console.log(error);
            this.money = this.card.money;
            console.log(this.money);
            console.log(this.amount);
            this.account.amount += this.money 
            this.accountService.updateAccount(this.accountId,this.account).subscribe(
              (data:any)=>{console.log(data),
                (error:any)=>console.log(error);

                this.transaction.info = "Recharge Wallet";
                this.transaction.paymentType= this.money;
                this.transaction.remarks = "Credit"
                this.transaction.transactionStatus="Success";
                this.transactionService.addtransaction(this.transaction,this.customerId,this.accountId).subscribe(
                  (data:any)=>{
                    console.log(data);
                  }
                )
                alert("Amount Added Successfully");
                this.router.navigate(['/wallet',this.customerId]);
              }
            )
          }
        )
      }
      )
  }
  public home()
{
  this.router.navigate(['/customerhome',this.customerId])
}
}
