import { Component, OnInit } from '@angular/core';
import { Booking } from '../../module/booking';
import { BookingService } from 'src/app/services/booking.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-bookinglist',
  templateUrl: './bookinglist.component.html',
  styleUrls: ['./bookinglist.component.css']
})
export class BookinglistComponent implements OnInit {
  booking = new Booking();
  bookinglist:any;
    constructor(private bookingService:BookingService,private route:Router) { }
  
    ngOnInit(): void {
    this.getAllBookingList();
  
    }
    getAllBookingList()
    {
    this.bookingService.getAllBookingsService().subscribe(
      (data:any)=>{console.log(data),
      this.bookinglist=data,
      console.log("Customer = "+this.booking.customerId);
    },
      error=>console.log(error)
    )
      }
  
    deleteBooking(bookingId:number)
    {
      this.bookingService.deleteBookingService(bookingId).subscribe(
        data=>{console.log("Deleted Succesfully");
        alert("Booking Cancelled....");
        this.getAllBookingList();},
        error=>console.log("error")
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
