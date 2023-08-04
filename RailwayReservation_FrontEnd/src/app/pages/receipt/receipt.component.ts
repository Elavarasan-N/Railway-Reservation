import { Component, OnInit } from '@angular/core';
import { Payment } from '../module/payment';
import { ActivatedRoute, Router } from '@angular/router';
import { PaymentService } from 'src/app/services/payment.service';
import { BookingService } from 'src/app/services/booking.service';
import { Booking } from '../module/booking';

@Component({
  selector: 'app-receipt',
  templateUrl: './receipt.component.html',
  styleUrls: ['./receipt.component.css']
})
export class ReceiptComponent implements OnInit {
  paymentId:number = 0;
  customerId:number = 0;
  payment=new Payment();
  booking=new Booking();
    constructor(private activatedRoute:ActivatedRoute,private route:Router,private paymentService:PaymentService,private bookingService:BookingService) { }
  
    ngOnInit(): void {
  this.paymentId=this.activatedRoute.snapshot.params["paymentId"]
  this.customerId=this.activatedRoute.snapshot.params["customerId"]
  this.getPaymentDetails()
    }
  getPaymentDetails()
  {
    this.paymentService.getPaymentDetailsService(this.paymentId).subscribe(
      (data:any)=>{console.log(data),
      this.payment=data},
      error=>console.log(error)
    )
  }
  home()
  {
    this.route.navigate(['/customerhome',this.customerId])
  }
  logOut()
  {
    this.route.navigate(['/welcomepage'])
  }
  aboutUs()
{
  this.route.navigate(['/aboutus'])
}
  }