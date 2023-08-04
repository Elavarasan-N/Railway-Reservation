import { Component, OnInit } from '@angular/core';
import { Train } from '../../module/train';
import { Customer } from '../../module/customer';
import { TrainService } from 'src/app/services/train.service';
import { Payment } from '../../module/payment';
import { PaymentService } from 'src/app/services/payment.service';
import { BookingService } from 'src/app/services/booking.service';
import { Booking } from '../../module/booking';
import { ActivatedRoute, Router } from '@angular/router';
import { Card } from '../../module/card';
import { CardService } from 'src/app/services/card.service';
import { Account } from '../../module/account';
import { Transaction } from '../../module/transaction';
import { TransactionService } from 'src/app/services/transaction.service';
import { AccountService } from 'src/app/services/account.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit 
{
trainId:any;
customerId:any;
paymentId:any;
paymentMode:any;
trainPrice:any;
totalPrice:any;
traveller:any;
bookingId:any;
accountId:any;
cardId:any;
amount:any;
money:any;
symbol:any;
paymentSelection:any;
cardBoolean:any;
walletBoolean:any;
walletBalance:any;
othersBoolean:any;

train = new Train();
payment=new Payment();
customer=new Customer();
booking=new Booking();
card=new Card();
account=new Account();
transaction=new Transaction();

  constructor(private activatedRout:ActivatedRoute,private paymentService:PaymentService,private bookingService:BookingService,
    private trainService:TrainService,private accountService:AccountService,private transactionService:TransactionService,private cardService:CardService,private router:Router) { }
  date=new Date();
  currentYear=this.date.getUTCFullYear();
  currentMonth=this.date.getUTCMonth()+1;
  currentday=this.date.getUTCDate();
  FinalMonth:any;
  FinalDay:any;
  todayDate:any = "";

  ngOnInit(): void {

    this.payment.paymentMode = "Card";
    this.trainId=this.activatedRout.snapshot.params['trainId'];
    this.customerId=this.activatedRout.snapshot.params['customerId'];
    this.bookingId=this.activatedRout.snapshot.params['bookingId'];
    this.accountId=this.activatedRout.snapshot.params['accountId'];

  console.log(" customerId = "+this.customerId)
  console.log("trainId = "+this.trainId);
  console.log("Booking = "+this.bookingId);
  console.log("Account = "+this.accountId);

    if(this.currentMonth<10)
    {
      this.FinalMonth="0"+this.currentMonth;
    
    }else{
      this.FinalMonth=this.currentMonth;
    }
   
    if(this.currentday<10)
    {
      this.FinalDay="0"+this.currentday;
    
    }else{
      this.FinalDay=this.currentday;
    }
this.todayDate=this.FinalMonth+"-"+this.FinalDay+"-"+this.currentYear;
console.log("System Date"+this.todayDate)

  this.getTrainDetails();
 
  this.getCustomerDetails();

  this.getAccountDetails();
  }
  getDateDiff(sDate: Date,eDate: Date)
{
  var startDate=new Date(sDate);
  var endDate=new Date(eDate);
  var Time=endDate.getTime()-startDate.getTime();
  return Time / (1000*3600*24);
}
getTrainDetails()
{
  this.bookingService.getBookingById(this.bookingId).subscribe(
    (data:any)=>{console.log(data),
    this.booking = data,console.log(" traveller "+this.booking.traveller)
  },
    error=>console.log(error)
  ),
  this.trainService.getTrainById(this.trainId).subscribe(
    (data:any)=>{console.log(data),
    this.train = data,
    console.log("train price = "+this.train.trainPrice),
    this.payment.totalPrice=(this.booking.traveller)*(this.train.trainPrice),
    console.log("total price "+this.payment.totalPrice)},
    error=>console.log(error)
  )
}
  getCustomerDetails()
  {
    this.payment.paidDate = this.todayDate;
    console.log("paid date"+this.payment.paidDate);
this.paymentService.getCustomerDetailsService(this.customerId).subscribe(
  (data:any)=>{console.log(data),
  this.customer=data,console.log("firstname = "+this.customer.firstName)},
  error=>console.log(error)
)
  }

  getAccountDetails()
  {
    this.accountService.getAccountByCustomerId(this.customerId).subscribe(
      (data:any)=>{console.log(data),
        this.account = data;
         this.amount = this.account.amount;
          this.symbol = '$';
        (error:any)=>console.log(error);
      }
    )
  }

  payments = ["Card","Wallet","Others"];


  public addToPayment(paymentId:number){

    this.booking.bookedDate = this.todayDate;
    this.payment.expYear = this.currentMonth + this.currentYear;
    this.cardService.addCard(this.card).subscribe(
      (data:any)=>{console.log(data),
        (error:any)=>console.log(error);
        this.cardId = data.cardId;

        this.cardService.getCardById(this.cardId).subscribe(
          (data:any)=>{console.log(data),
            (error:any)=>console.log(error);
            this.money = this.card.money;

                this.transaction.info = "Booked Train thru card";
                this.transaction.paymentType= this.payment.totalPrice;
                this.transaction.remarks = "Debit"
                this.transaction.transactionStatus="Success";
                this.transactionService.addtransaction(this.transaction,this.customerId,this.accountId).subscribe(
                  (data:any)=>{
                    console.log(data);
                  }
                )

        this.paymentService.addToPaymentService(this.trainId,this.customerId,this.bookingId,this.payment).subscribe(
        (data:any)=>{console.log(data);
          this.paymentId=data.paymentId;
          alert("Payment Success");
          this.router.navigate(['/paymentreceipt',this.trainId,this.customerId,this.bookingId,data.paymentId]);
        }
    )
  }
  )
}
)
}

public addPayment()
{
  console.log(this.account.amount);
  console.log(this.payment.totalPrice);
  if (this.account.amount >= this.payment.totalPrice)
  {
  console.log(this.accountId);
    this.account.amount -= this.payment.totalPrice;
    this.accountService.updateAccount(this.accountId,this.account).subscribe(
      (data:any)=>{console.log(data),
        (error:any)=>console.log(error);

        this.transaction.info = "Booked Train thru Wallet";
        this.transaction.paymentType= this.payment.totalPrice;
        this.transaction.remarks = "Debit"
        this.transaction.transactionStatus="Success";
        this.transactionService.addtransaction(this.transaction,this.customerId,this.accountId).subscribe(
          (data:any)=>{
            console.log(data);
          }
        )

        this.paymentService.addToPaymentService(this.trainId,this.customerId,this.bookingId,this.payment).subscribe(
          (data:any)=>{console.log(data);
            this.paymentId=data.paymentId;
            alert("Payment Success");
            this.router.navigate(['/paymentreceipt',this.trainId,this.customerId,this.bookingId,data.paymentId]);
          }
          )

        this.router.navigate(['/paymentreceipt',this.trainId,this.customerId,this.bookingId,this.paymentId]);
      }
    )

  } 
  else if (this.account.amount <= this.payment.totalPrice)
  {
    this.walletBalance = "Insufficient Balance";
  }
}

public paymentModeSelection(event:any)
{
  console.log("message Pm = "+this.paymentSelection);
  if(this.paymentSelection==="Card")
  {
    this.cardBoolean=true;
    this.walletBoolean=false;
    this.othersBoolean=false;
  }
  if(this.paymentSelection==="Wallet")
  {
    this.walletBoolean=true;
    this.cardBoolean=false
    this.othersBoolean=false;
  }
  if(this.paymentSelection==="Others")
  {
    this.othersBoolean=true;
    this.walletBoolean=false;
    this.cardBoolean=false;
  }
}

back()
{
  this.router.navigate(['/viewroomlist',this.paymentId,this.customerId])
}
home()
{
  this.router.navigate(['/customerhomeplace',this.customerId])
}
customerProfile()
{
  this.router.navigate(['profile',this.customerId])
}
logOut()
{
  this.router.navigate(['/welcomepage'])
}
contactUs()
    {
      this.router.navigate(['/contact'])
    }
}

 
