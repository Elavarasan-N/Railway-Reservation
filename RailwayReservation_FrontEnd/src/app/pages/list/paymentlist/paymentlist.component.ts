import { Component, OnInit } from '@angular/core';
import { Payment } from '../../module/payment';
import { PaymentService } from 'src/app/services/payment.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-paymentlist',
  templateUrl: './paymentlist.component.html',
  styleUrls: ['./paymentlist.component.css']
})
export class PaymentlistComponent  implements OnInit {

  payment = new Payment();
  paymentlist:any;
    constructor(private paymentService:PaymentService,private route:Router) { }
  
    ngOnInit(): void {
      this.paymentService.getAllPaymentsService().subscribe(
        (data:any)=> {console.log(data),
        this.paymentlist=data},
        error=>console.log(error)
      )
    }
    aboutUs()
    {
      this.route.navigate(['/aboutus'])
    }
    logOut()
    {
      this.route.navigate(['/welcomepage'])
    }
    p: number = 1;
    count: number = 5;
  }
