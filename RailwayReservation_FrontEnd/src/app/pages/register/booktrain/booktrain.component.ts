import { Component, OnInit } from '@angular/core';
import { Train } from '../../module/train';
import { ActivatedRoute, Router } from '@angular/router';
import { TrainService } from 'src/app/services/train.service';
import { Customer } from '../../module/customer';
import { Booking } from '../../module/booking';
import { BookingService } from 'src/app/services/booking.service';

@Component({
  selector: 'app-booktrain',
  templateUrl: './booktrain.component.html',
  styleUrls: ['./booktrain.component.css']
})
export class BooktrainComponent implements OnInit{
  trainId:any;
  customerId:any;
  bookingId:any;
  accountId:any;
  booking = new Booking();
  customer = new Customer();
  train = new Train();
constructor(private activatedRouter:ActivatedRoute,private bookingService:BookingService, private trainService:TrainService,private route:Router){}
date=new Date();
  currentYear=this.date.getUTCFullYear();
  currentMonth=this.date.getUTCMonth()+1;
  currentday=this.date.getUTCDate();
  FinalMonth:any;
  FinalDay:any;
 todayDate:any="";
ngOnInit(): void {
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
    this.todayDate = this.FinalMonth+"-"+this.FinalDay+"-"+this.currentYear;
    console.log("system date = "+this.todayDate);
 this.trainId=this.activatedRouter.snapshot.params['trainId'];
 this.customerId=this.activatedRouter.snapshot.params['customerId'];
 this.accountId=this.activatedRouter.snapshot.params['accountId'];
 console.log(this.customerId);
 console.log(this.trainId);
 console.log(this.accountId);

this.trainService.getTrainById(this.trainId).subscribe(
 (data:any)=>{
   this.train=data;
 }
)
this.booking.bookedDate = this.todayDate;
console.log("Booked date = "+this.booking.bookedDate);
}
travellers=["1","2","3","4","5"];
public addtraveller(bookingId:number){
  this.bookingService.bookTrainService(this.trainId,this.customerId,this.booking).subscribe(
  (data:any)=>{console.log(data);
    this.bookingId=data.bookingId;
    alert("Travellers added");
    this.route.navigate(['/payment',this.trainId,this.customerId,this.accountId,data.bookingId]);
  }
  );
    }

    customerhome()
    {
      this.route.navigate(['/customerhome',this.customerId]);
    }

}
