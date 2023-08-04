import { Component, OnInit } from '@angular/core';
import { Booking } from '../../module/booking';
import { BookingService } from 'src/app/services/booking.service';
import { ActivatedRoute, Router } from '@angular/router';
import { PaymentService } from 'src/app/services/payment.service';
import { formatDate } from '@angular/common';

@Component({
  selector: 'app-viewcustomerbooking',
  templateUrl: './viewcustomerbooking.component.html',
  styleUrls: ['./viewcustomerbooking.component.css']
})
export class ViewcustomerbookingComponent implements OnInit {
  booking = new Booking();
  customerId:any;
  bookingId:any;
  departureTime:any;
  bookingview:any;
  paymentview:any;
  constructor(private bookingService:BookingService,private paymentService:PaymentService,private activatedRoute:ActivatedRoute,private route:Router) { }
  date=new Date();
  
  currentYear=this.date.getUTCFullYear();
  currentMonth=this.date.getUTCMonth()+1;
  currentday=this.date.getUTCDate();
  jstoday = formatDate(this.date, 'hh a', 'en-US', '+0530');
  FinalMonth:any;
  FinalDay:any;
  trainDate:any;
 todayDate:any;
 todayDate1:any;
  ngOnInit(): void {
    this.customerId=this.activatedRoute.snapshot.params["customerId"]
  this.getAllBookings();
  this.getAllPayments();
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
this.todayDate=this.FinalMonth+"/"+this.FinalDay+"/"+this.currentYear;
console.log("System Date = "+this.todayDate)

  }
  getAllBookings()
  {
  this.bookingService.getAllBookingsByCustomerIdService(this.customerId).subscribe(
    (data:any)=>{console.log(data),
    this.bookingview=data},
    error=>console.log(error)
  )
  }
  getAllPayments()
  {
    this.paymentService.getCustomerDetailsService(this.customerId).subscribe(
      (data:any)=>{console.log(data),
        this.paymentview=data;
      },
        error=>console.log(error)
    )
  }
  cancelBooking(bookingId:number)
  {
    console.log("booking id = "+bookingId);
    this.bookingService.getBookingById(bookingId).subscribe(
      (data:any)=>{console.log(data);
        this.booking = data,
        (error:any)=>console.log(error);
        console.log("booked date = "+this.booking.bookedDate);
        console.log("today = "+this.todayDate);
        console.log("DepartureDate = "+this.booking.departureTime);
        console.log("departureTime = "+((this.booking.departureTime[11]+this.booking.departureTime[12])-12));
        //this.trainDate = this.booking.departureTime[5]+this.booking.departureTime[6]+'/'+this.booking.departureTime[8] + this.booking.departureTime[9] + '/' + this.booking.departureTime[0]+this.booking.departureTime[1]+this.booking.departureTime[2]+this.booking.departureTime[3];
        console.log("departureDate = "+this.trainDate);
        console.log(this.jstoday);
        
        this.bookingService.deleteBookingService(bookingId).subscribe(
          (data:any)=>{console.log(data),
            (error:any)=>console.log("error");
        }  
        )

      }
    )
  }

  logOut()
  {
    this.route.navigate(['/welcomepage'])
  }
  
  home()
  {
    this.route.navigate(['/customerhome',this.customerId])
  }
  contactUs()
  {
    this.route.navigate(['/contact'])
  }

    p: number = 1;
    count: number = 5;
}